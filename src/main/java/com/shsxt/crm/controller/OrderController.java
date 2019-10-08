package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.query.OrderQuery;
import com.shsxt.crm.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("order")
@Controller
public class OrderController extends BaseController {


    @Autowired
    private OrderService orderService;

    @RequestMapping("index")
    public String index(Model model, Integer cid) {
        model.addAttribute("cid",cid);
        return "order";
    }


    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> queryOrderByParams(@RequestParam(defaultValue = "1") Integer page,
                                                  @RequestParam(defaultValue = "10") Integer rows,
                                                  OrderQuery orderQuery,Integer cid) {
        orderQuery.setPageNum(page);
        orderQuery.setPageSize(rows);
        orderQuery.setCid(cid);
        return orderService.queryByParamsFroDataGrid(orderQuery);

    }


    @RequestMapping("queryOrderInfoByOrderNo")
    @ResponseBody
    public Map<String,Object>queryOrderInfoByOrderNo (String orderNo){
        System.out.println("---------------------");
        System.out.println(orderNo);
        System.out.println("---------------------");

        return orderService.queryOrderInfoByOrderNo(orderNo);
    }
}
