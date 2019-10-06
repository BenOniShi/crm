package com.shsxt.crm.services;

import com.shsxt.base.BaseService;
import com.shsxt.crm.db.dao.CustomerMapper;
import com.shsxt.crm.po.Customer;
import com.shsxt.crm.utils.AssertsUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Service
public class CustomerService extends BaseService<Customer, Integer> {

    @Autowired
    private CustomerMapper customerMapper;

    //定义正则表达式
    private Pattern p = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$");
    /**
     * 1.参数校验
     * 2.执行添加  修改  删除
     * @param customer
     */

    public void  saveCustomer(Customer customer){
        //参数校验   调用save方法

        cheackParams(customer);
        //设置默认参数
        customer.setCreateDate(new Date());
        customer.setUpdateDate(new Date());
        customer.setIsValid(1);
        String s = new SimpleDateFormat().
                format(new Date());
        customer.setKhno(s);
        customer.setState(0);// 未流失
        AssertsUtils.isTrue(save(customer)==0,"添加失败");
    }

    /**
     * 参数校验
     * @param customer
     */
    private void cheackParams(Customer customer) {
        AssertsUtils.isTrue(StringUtils.isBlank(customer.getName()),"客户名称不能为空");
        // 两种情况  判断 传递过来的customer对象是否有  id    如果没有id 就是添加方法  有id就是修改方法
        if (customer.getId()==null){
            //null就是添加方法  判断customer 里面有没有相同的记录
           AssertsUtils.isTrue(null!=(customerMapper.queryByUserName(customer.getName())),"该客户已存在");
        }else {
            //如果有id  就是修改方法  判断 传过来的customer对象修改的名字id 是否不是自己的    如果不是自己的  就不能修改
            Customer customer1 = customerMapper.queryByUserName(customer.getName());
            if (null!=customer1){
                AssertsUtils.isTrue( !(customer.getId().equals(customer1.getId())),"该用户已存在");
            }
        }
        //正则表达式验证手机号     (p.matcher(参数).matches)返回值   如果是手机号返回true  取反  不是
        AssertsUtils.isTrue(StringUtils.isBlank(customer.getPhone())||!(p.matcher(customer.getPhone()).matches()),"手机号格式不正确");
        AssertsUtils.isTrue(StringUtils.isBlank(customer.getFr()),"请输入法人代表!");
        AssertsUtils.isTrue(null ==customer.getZczj()|| Integer.parseInt(customer.getZczj())<=0,"请输入注册资金!");
        AssertsUtils.isTrue(StringUtils.isBlank(customer.getYyzzzch()),"请输入营业执照!");
        AssertsUtils.isTrue(StringUtils.isBlank(customer.getGsdjh()),"请输入国税号!");
        AssertsUtils.isTrue(StringUtils.isBlank(customer.getDsdjh()),"请输入地税号!");

    }


    /**
     * 修改方法   参数校验
     * @param customer
     */
    public void updateCustomer(Customer customer) {
        //判断该用户是否存在
        AssertsUtils.isTrue(null==customer.getId()||null==queryById(customer.getId()),"更新的账户不存在");

        cheackParams(customer);
        //设置参数
        customer.setUpdateDate(new Date());
        AssertsUtils.isTrue(0==update(customer),"更新失败");
    }


    /**
     * 删除方法
     */
    public void deleteCustomer(Integer id){
        //判断用户是否存在
        AssertsUtils.isTrue(null==id||null==queryById(id),"您选择的删除记录不存在");
        AssertsUtils.isTrue(delete(id)==0,"删除失败");

    }
}
