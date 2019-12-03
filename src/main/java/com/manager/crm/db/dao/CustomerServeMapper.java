package com.manager.crm.db.dao;

import com.manager.base.BaseMapper;
import com.manager.crm.po.CustomerServe;

import java.util.List;
import java.util.Map;

public interface CustomerServeMapper extends BaseMapper<CustomerServe,Integer> {


    public List<Map<String,Object>> countServeTypeParams();
}