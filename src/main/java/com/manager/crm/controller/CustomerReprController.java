package com.manager.crm.controller;

import com.manager.base.BaseController;
import com.manager.crm.model.ResultInfo;
import com.manager.crm.po.CustomerRepr;
import com.manager.crm.query.CustomerReprQuery;
import com.manager.crm.services.CustomerReprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
@Controller
@RequestMapping("customerRepr")
public class CustomerReprController extends BaseController {

    @Autowired
    private CustomerReprService customerReprService;

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryCustomerReprByParams(@RequestParam(defaultValue = "1")Integer page,
                                                        @RequestParam(defaultValue = "10")Integer rows,
                                                        CustomerReprQuery customerReprQuery,Integer lossId){
        customerReprQuery.setPageNum(page);
        customerReprQuery.setPageSize(rows);
        customerReprQuery.setLossId(lossId);
        return customerReprService.queryByParamsFroDataGrid(customerReprQuery);
    }


    @RequestMapping("save")
    @ResponseBody
    public ResultInfo saveCustomerReprByLossId(CustomerRepr customerRepr, Integer lossId){
        customerReprService.saveCustomerRepr(customerRepr,lossId);
        return success();
    }




    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteCustomerReprByLossId( Integer id){
        customerReprService.deleteCustomerReprByLossId(id);
        return success();
    }

}
