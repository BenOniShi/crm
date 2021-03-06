package com.manager.crm.controller;

import com.manager.base.BaseController;
import com.manager.crm.model.ResultInfo;
import com.manager.crm.po.CusDevPlan;
import com.manager.crm.query.CusDevPlanQuery;
import com.manager.crm.query.SaleChanceQuery;
import com.manager.crm.services.CusDevPlanService;
import com.manager.crm.services.SaleChanceService;
import com.manager.crm.services.UserSerive;
import com.manager.crm.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Controller
@RequestMapping("cusDevPlan")
public class CusDevPlanContorller extends BaseController {

    @Autowired
    private SaleChanceService saleChanceService;
    @Autowired
    private UserSerive userSerive;
    @Autowired
    private CusDevPlanService cusDevPlanService;

    @RequestMapping("index")
    public String index() {
        return "cus_dev_plan";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object>   queryStatedSaleChance(@RequestParam(defaultValue = "1") Integer page,
                                                      @RequestParam(defaultValue = "10")Integer rows,
                                                      SaleChanceQuery saleChanceQuery, HttpServletRequest request){

        saleChanceQuery.setPageNum(page);
        saleChanceQuery.setPageSize(rows);

        saleChanceQuery.setAssignMan(userSerive.queryById(LoginUserUtil.releaseUserIdFromCookie(request)).getTrueName());
        return saleChanceService.queryByParamsFroDataGrid(saleChanceQuery);
    }
    @RequestMapping("queryCusDevPlansBySid")
    @ResponseBody
    public Map<String,Object>  queryCusDevPlanBySid(@RequestParam(defaultValue = "1" )Integer pageNum,
                                                    @RequestParam(defaultValue = "10")Integer rows,
                                                    CusDevPlanQuery cusDevPlanQuery,Integer sid){
        cusDevPlanQuery.setSid(sid);
        cusDevPlanQuery.setPageNum(pageNum);
        cusDevPlanQuery.setPageSize(rows);
        return cusDevPlanService.queryByParamsFroDataGrid(cusDevPlanQuery);

    }


    @RequestMapping("save")
    @ResponseBody
    public ResultInfo saveCusDevPlan(CusDevPlan cusDevPlan,Integer saleChanceid){
        cusDevPlanService.saveCusDevPlan(cusDevPlan,saleChanceid);
        return success();
    }


    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteCusDevPlan(Integer id){
        cusDevPlanService.deleteCusDevPlan(id);
        return success();
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateCusDevPlan(CusDevPlan cusDevPlan,Integer saleChanceid){
        cusDevPlanService.updateCusDevPlan(cusDevPlan,saleChanceid);
        return success();
    }

}
