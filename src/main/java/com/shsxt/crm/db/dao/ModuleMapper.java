package com.shsxt.crm.db.dao;

import com.shsxt.base.BaseMapper;
import com.shsxt.crm.dto.TreeDto;
import com.shsxt.crm.po.Module;

import java.util.List;

public interface ModuleMapper extends BaseMapper<Module,Integer> {



    public List<TreeDto> queryAllModules();
}