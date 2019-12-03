package com.manager.crm.db.dao;

import com.manager.base.BaseMapper;
import com.manager.crm.dto.CusNameAndCusSum;
import com.manager.crm.po.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper extends BaseMapper<Customer,Integer> {

    Customer queryByUserName(@Param(value = "userName") String userName);



     List<CusNameAndCusSum> countSumByParams();



     List<Map<String,Object>> countLevelByCustomer();
}