package com.shsxt.crm.services;

import com.shsxt.base.BaseService;
import com.shsxt.crm.db.dao.CustomerOrderMapper;
import com.shsxt.crm.po.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderService  extends BaseService<CustomerOrder,Integer> {

    @Autowired
    private CustomerOrderMapper customerOrderMapper;

    public Map<String, Object> queryOrderInfoByOrderNo(String orderNo) {
        return customerOrderMapper.queryOrderInfoByOrderNo(orderNo);
    }
}
