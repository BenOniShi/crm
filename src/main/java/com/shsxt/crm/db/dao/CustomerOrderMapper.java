package com.shsxt.crm.db.dao;

import com.shsxt.base.BaseMapper;
import com.shsxt.crm.po.CustomerOrder;

import java.util.Map;

public interface CustomerOrderMapper  extends BaseMapper<CustomerOrder,Integer> {




    Map<String, Object> queryOrderInfoByOrderNo(String orderNo);
}