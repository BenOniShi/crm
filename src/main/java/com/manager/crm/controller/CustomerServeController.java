package com.manager.crm.controller;

import com.manager.base.BaseController;
import com.manager.crm.query.CustomerServeQuery;
import com.manager.crm.services.CustomerServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
@RequestMapping("customerserve")
@Controller
public class CustomerServeController extends BaseController {


    @Autowired
    private CustomerServeService customerServeService;

    @RequestMapping("index")
    public String index(){


        return null;
    }


    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryCustomerServeByParams(@RequestParam (defaultValue = "1")Integer page,
                                                         @RequestParam(defaultValue = "10")Integer rows,
                                                         CustomerServeQuery customerServeQuery){
        customerServeQuery.setPageNum(page);
        customerServeQuery.setPageSize(rows);
        return customerServeService.queryByParamsFroDataGrid(customerServeQuery);
    }


    @RequestMapping("count2")
    @ResponseBody
    public Map<String,Object> countServeTypeParams(){
        return customerServeService.countServeTypeParams();
    }
}
