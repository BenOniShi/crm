package com.shsxt.crm.db.dao;

import com.shsxt.base.BaseMapper;
import com.shsxt.crm.po.CustomerServe;

import java.util.List;
import java.util.Map;

public interface CustomerServeMapper extends BaseMapper<CustomerServe,Integer> {


    public List<Map<String,Object>> countServeTypeParams();
}