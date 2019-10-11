package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController extends BaseController {

    @RequestMapping("report/{type}")
    public String index(@PathVariable Integer type) {
        switch (type) {
            case 0:
                return "customer_gx";
            case 1:
                return "customer_fx";
            case 2:
                return "customer_fw";
            default:
                return "";
        }
    }
}
