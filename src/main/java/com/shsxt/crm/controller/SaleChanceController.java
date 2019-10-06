package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.query.SaleChanceQuery;
import com.shsxt.crm.services.SaleChanceService;
import com.shsxt.crm.services.UserSerive;
import com.shsxt.crm.utils.LoginUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("saleChance")
public class SaleChanceController extends BaseController {
    @Resource
    private SaleChanceService saleChanceService;


    @Resource
    private UserSerive userSerive;

    @RequestMapping("index")
    public String index() {

        return "sale_chance";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> querySaleChanceByParams(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows
            , SaleChanceQuery saleChanceQuery) {
        //设置query对象的当前页    pagesize 每页显示的数量
        saleChanceQuery.setPageNum(page);
        saleChanceQuery.setPageSize(rows);
        return saleChanceService.queryByParamsFroDataGrid(saleChanceQuery);

    }


    @RequestMapping("save")
    @ResponseBody
    public ResultInfo save(HttpServletRequest request, SaleChance saleChance) {
        //拿到用户id
        int i = LoginUserUtil.releaseUserIdFromCookie(request);
        //设置创建人的真实姓名
        saleChance.setCreateMan(userSerive.queryById(i).getTrueName());
        //调用  保存方法
        saleChanceService.saveSalChance(saleChance);
        return  success("机会数据添加成功");

    }

    @RequestMapping("update")
    @ResponseBody
    public ResultInfo update(SaleChance saleChance){
        saleChanceService.updateSaleChance(saleChance);
        return success();
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo delete(Integer id){
        saleChanceService.deleteSaleChance(id);
        return success();
    }


    @RequestMapping("querySaleChanceBySid")
    public String querySaleChanceBySid(Integer sid, Model model){
        System.out.println(sid);
        model.addAttribute("saleChance",saleChanceService.queryById(sid));

        return "sale_chance_dev";
    }


    @RequestMapping("updateSaleChanceResult")
    @ResponseBody
    public ResultInfo updateSaleChanceResult(Integer sid,Integer result){
        saleChanceService.updateSaleChanceResult(sid,result);
        return success();
    }
}
