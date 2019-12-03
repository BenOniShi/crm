package com.manager.crm.controller;

import com.manager.crm.query.OrderDetailsQuery;
import com.manager.crm.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("orderDetails")
@Controller
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;


    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryOrderDatailsByParams(@RequestParam(defaultValue = "1") Integer page,
                                                        @RequestParam(defaultValue = "10")Integer rows,
                                                        OrderDetailsQuery orderDetailsQuery){

        orderDetailsQuery.setPageNum(page);
        orderDetailsQuery.setPageSize(rows);
        return  orderDetailsService.queryByParamsFroDataGrid(orderDetailsQuery);
    }




}
