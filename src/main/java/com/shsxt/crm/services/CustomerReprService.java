package com.shsxt.crm.services;

import com.shsxt.base.BaseService;
import com.shsxt.crm.po.CustomerRepr;
import com.shsxt.crm.utils.AssertsUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerReprService extends BaseService<CustomerRepr,Integer> {

    public void saveCustomerRepr(CustomerRepr customerRepr, Integer lossId) {
        checkCustomerReprParams(customerRepr);
        customerRepr.setCreateDate(new Date());
        customerRepr.setUpdateDate(new Date());
        customerRepr.setLossId(lossId);
        customerRepr.setIsValid(1);
        AssertsUtils.isTrue(0==save(customerRepr),"添加暂缓计划失败");
    }



    private void checkCustomerReprParams(CustomerRepr customerRepr) {
        AssertsUtils.isTrue(StringUtils.isBlank(customerRepr.getMeasure()),"暂缓计划不能为空");
    }


    public void deleteCustomerReprByLossId(Integer id) {
        AssertsUtils.isTrue(null==id,"请选择要删除的数据");
        AssertsUtils.isTrue(0==delete(id),"删除失败");
    }
}
