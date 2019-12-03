package com.manager.crm.services;

import com.manager.base.BaseService;
import com.manager.crm.db.dao.ModuleMapper;
import com.manager.crm.dto.TreeDto;
import com.manager.crm.po.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService extends BaseService<Module,Integer> {


    @Autowired
    private ModuleMapper moduleMapper;

    public List<TreeDto> queryAllModules(){
        return moduleMapper.queryAllModules();
    }
}
