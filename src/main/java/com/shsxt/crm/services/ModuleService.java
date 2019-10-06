package com.shsxt.crm.services;

import com.shsxt.base.BaseService;
import com.shsxt.crm.db.dao.ModuleMapper;
import com.shsxt.crm.dto.TreeDto;
import com.shsxt.crm.po.Module;
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
