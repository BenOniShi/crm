package com.manager.crm.db.dao;

import com.manager.base.BaseMapper;
import com.manager.crm.dto.TreeDto;
import com.manager.crm.po.Module;

import java.util.List;

public interface ModuleMapper extends BaseMapper<Module,Integer> {



    public List<TreeDto> queryAllModules();
}