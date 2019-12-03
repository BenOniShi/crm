package com.manager.crm.db.dao;

import com.manager.base.BaseMapper;
import com.manager.crm.po.CustomerOrder;

import java.util.Map;

public interface CustomerOrderMapper  extends BaseMapper<CustomerOrder,Integer> {




    Map<String, Object> queryOrderInfoByOrderNo(String orderNo);
}