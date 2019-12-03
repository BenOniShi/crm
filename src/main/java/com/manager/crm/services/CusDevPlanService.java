package com.manager.crm.services;

import com.manager.base.BaseService;
import com.manager.crm.po.CusDevPlan;
import com.manager.crm.utils.AssertsUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CusDevPlanService extends BaseService<CusDevPlan,Integer> {


    /**
     * 保存方法
     * @param cusDevPlan
     */
    public  void  saveCusDevPlan(CusDevPlan cusDevPlan,Integer sid){
        checkCusDevPlanParams(cusDevPlan);
        cusDevPlan.setCreateDate(new Date());
        cusDevPlan.setUpdateDate(new Date());
        cusDevPlan.setPlanDate(new Date());
        cusDevPlan.setIsValid(1);
        cusDevPlan.setSaleChanceId(sid);

        AssertsUtils.isTrue(save(cusDevPlan)==0,"添加开发计划失败");

    }

    /**
     * 参数判断
     * @param cusDevPlan
     */
    private void checkCusDevPlanParams(CusDevPlan cusDevPlan) {
        AssertsUtils.isTrue(StringUtils.isBlank(cusDevPlan.getPlanItem()),"开发计划不能为空");
        AssertsUtils.isTrue(StringUtils.isBlank(cusDevPlan.getExeAffect()),"开发结果不能为空");
    }

    /**
     * 更新方法
     * @param cusDevPlan
     */
    public void updateCusDevPlan(CusDevPlan cusDevPlan,Integer sid){
        checkCusDevPlanParams(cusDevPlan);
        cusDevPlan.setUpdateDate(new Date());
        cusDevPlan.setSaleChanceId(sid);
        AssertsUtils.isTrue(null==queryById(cusDevPlan.getId()),"更新的结果不存在");
        AssertsUtils.isTrue(0==update(cusDevPlan),"更新失败");

    }

    /**
     * 删除方法
     */
    public void deleteCusDevPlan(Integer id){
        CusDevPlan cusDevPlan = queryById(id);
        AssertsUtils.isTrue(null==cusDevPlan,"要删除的记录不存在");
        cusDevPlan.setIsValid(0);
        AssertsUtils.isTrue(0==update(cusDevPlan),"删除失败");
    }
}
