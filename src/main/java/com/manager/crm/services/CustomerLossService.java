package com.manager.crm.services;

import com.manager.base.BaseService;
import com.manager.crm.po.CustomerLoss;
import com.manager.crm.utils.AssertsUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerLossService extends BaseService<CustomerLoss,Integer> {


    public void updateCustomerLossByLossId(Integer lossid,String mesg) {
        AssertsUtils.isTrue(null==lossid||null==queryById(lossid),"当前没有开发数据");
        CustomerLoss customerLoss = queryById(lossid);
        customerLoss.setState(1);
        customerLoss.setLossReason(mesg);
        customerLoss.setConfirmLossTime(new Date());
        customerLoss.setUpdateDate(new Date());
        AssertsUtils.isTrue(0==update(customerLoss),"终止失败");
    }
}
