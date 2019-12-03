package com.manager.crm.services;

import com.manager.base.BaseService;
import com.manager.crm.db.dao.CustomerOrderMapper;
import com.manager.crm.po.CustomerOrder;
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
