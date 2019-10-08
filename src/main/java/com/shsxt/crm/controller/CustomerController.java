package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.po.Customer;
import com.shsxt.crm.query.CustomerQuery;
import com.shsxt.crm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping("index")
    public String index() {


        return "customer";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> queryCustomerByParams(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer rows,
                                    CustomerQuery customerQuery) {
        customerQuery.setPageNum(page);
        customerQuery.setPageSize(rows);
        return customerService.queryByParamsFroDataGrid(customerQuery);

    }

    /**
     * 保存方法
     * @param customer
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public ResultInfo save(Customer customer){
        customerService.saveCustomer(customer);

        return success("添加成功");
    }

    /**
     * 更新
     * @param customer
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo update(Customer customer){
        customerService.updateCustomer(customer);

        return success("更新成功");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo delete(Integer id){
        customerService.deleteCustomer(id);

        return success("删除成功");
    }



}
