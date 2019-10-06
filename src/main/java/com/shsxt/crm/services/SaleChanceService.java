package com.shsxt.crm.services;

import com.shsxt.base.BaseService;
import com.shsxt.crm.db.dao.SaleChanceMapper;
import com.shsxt.crm.enums.DevResultStatus;
import com.shsxt.crm.enums.StateStatus;
import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.utils.AssertsUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.regex.Pattern;

@Service
public class SaleChanceService extends BaseService<SaleChance, Integer> {

    //定义正则表达式
    private Pattern p = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$");
    @Autowired
    private SaleChanceMapper saleChanceMapper;


    /**
     * 营销机会保存方法  1.参数校验
     * 2.分配状态
     * 3.开发状态
     * 4.有效值
     * 5.创建人
     * 6.执行添加
     *
     * @param saleChance
     */
    public void saveSalChance(SaleChance saleChance) {

        checkSalChanceParams(saleChance);
        //设置分配状态默认值   开发状态默认值
        //未分配
        saleChance.setState(StateStatus.UN_STATED.getState());
        saleChance.setIsValid(1);
        saleChance.setCreateDate(new Date());
        saleChance.setUpdateDate(new Date());
        //未开发
        saleChance.setDevResult(DevResultStatus.UN_DEV.getDev());
        //如果未选择分配人  分配状态未 0
        if (StringUtils.isNotBlank(saleChance.getAssignMan())){
            saleChance.setAssignTime(new Date());
            saleChance.setState(StateStatus.STATED.getState());
        }
        AssertsUtils.isTrue(save(saleChance)==0,"机会数据添加失败");


    }

    /**
     * 校验参数
     *
     * @param saleChance
     */
    private void checkSalChanceParams(SaleChance saleChance) {


        AssertsUtils.isTrue(StringUtils.isBlank(saleChance.getCustomerName()), "请输入客户名称");
        AssertsUtils.isTrue(StringUtils.isBlank(saleChance.getLinkMan()), "请输入联系人");
        AssertsUtils.isTrue(StringUtils.isBlank(saleChance.getLinkPhone()), "请输入手机号");
        /**
         * 正则判断是否是手机号
         */
        AssertsUtils.isTrue(!(p.matcher(saleChance.getLinkPhone()).matches()), "手机号格式不正确");
    }

    /**
     * 修改 营销机会数据
     * @param saleChance
     */
    public void updateSaleChance(SaleChance saleChance) {
        checkSalChanceParams(saleChance);
        AssertsUtils.isTrue(update(saleChance)==0,"营销机会数据更新失败");
    }

    /**
     * 删除营销机会数据
     * @param id
     */
    public void deleteSaleChance(Integer id) {
        //根据id查询 salechance数据
        SaleChance saleChance = queryById(id);
        AssertsUtils.isTrue(null==saleChance,"您要删除的数据不存在");
        saleChance.setIsValid(0);
        AssertsUtils.isTrue(0==update(saleChance),"删除失败");
    }

    public void updateSaleChanceResult(Integer sid, Integer result) {
        AssertsUtils.isTrue(null==sid,"当前没有开发计划");
        SaleChance saleChance = queryById(sid);
        AssertsUtils.isTrue(null==saleChance,"当前没有开发计划");
        saleChance.setDevResult(result);
        AssertsUtils.isTrue(0==update(saleChance),"操作失败了啊");

    }
    public void test(){
        System.out.println("方法执行前我被执行了");
    }
}
