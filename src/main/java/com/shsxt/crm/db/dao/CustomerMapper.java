package com.shsxt.crm.db.dao;

import com.shsxt.base.BaseMapper;
import com.shsxt.crm.po.Customer;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper extends BaseMapper<Customer,Integer> {

    Customer queryByUserName(@Param(value = "userName") String userName);
}