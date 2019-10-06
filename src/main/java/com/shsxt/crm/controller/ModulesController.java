package com.shsxt.crm.controller;

import com.shsxt.crm.dto.TreeDto;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("module")
public class ModulesController {


    @Autowired
    private ModuleService moduleService;

    @RequestMapping("index")
    public String index(){
        return "module";


    }
    @RequestMapping("tree")
    @ResponseBody
    public List<TreeDto> queryAllModules(){

        return moduleService.queryAllModules();
    }
}
