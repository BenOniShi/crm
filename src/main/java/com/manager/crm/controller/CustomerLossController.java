package com.manager.crm.controller;

import com.manager.base.BaseController;
import com.manager.crm.model.ResultInfo;
import com.manager.crm.po.CustomerLoss;
import com.manager.crm.query.CustomerLossQuery;
import com.manager.crm.services.CustomerLossService;
import com.manager.crm.utils.AssertsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("customerLoss")
public class CustomerLossController extends BaseController {



    @Autowired
    private CustomerLossService customerLossService;

    @RequestMapping("index")
    public String index(){
        return "customer_loss";
    }


    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryCustomerLossByParams(@RequestParam(defaultValue = "1")Integer pageNum,
                                                        @RequestParam(defaultValue = "10")Integer rows,
                                                        CustomerLossQuery customerLossQuery){
        customerLossQuery.setPageNum(pageNum);
        customerLossQuery.setPageSize(rows);
        return customerLossService.queryByParamsFroDataGrid(customerLossQuery);
    }

    @RequestMapping("queryCustomerLossByLossId")
    public String queryCustomerLossByLossId(Integer id, ModelMap modelMap){
        CustomerLoss customerLoss = customerLossService.queryById(id);
        AssertsUtils.isTrue(null==customerLoss,"未查询到客户流失情况详情");
        modelMap.addAttribute("customerLoss",customerLoss);
        return "customer_loss_repr";
    }


    @RequestMapping("updateCustomerLossByLossId")
    @ResponseBody
    public ResultInfo updateCustomerLossByLossId(Integer lossid,String mesg){
        customerLossService.updateCustomerLossByLossId(lossid,mesg);
        return success();
    }


}
