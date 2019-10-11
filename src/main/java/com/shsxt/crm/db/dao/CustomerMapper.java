package com.shsxt.crm.db.dao;

import com.shsxt.base.BaseMapper;
import com.shsxt.crm.dto.CusNameAndCusSum;
import com.shsxt.crm.po.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper extends BaseMapper<Customer,Integer> {

    Customer queryByUserName(@Param(value = "userName") String userName);



     List<CusNameAndCusSum> countSumByParams();



     List<Map<String,Object>> countLevelByCustomer();
}