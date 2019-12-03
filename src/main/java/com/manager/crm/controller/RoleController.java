package com.manager.crm.controller;

import com.manager.base.BaseController;
import com.manager.crm.model.ResultInfo;
import com.manager.crm.po.Role;
import com.manager.crm.query.RoleQuery;
import com.manager.crm.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;


    @RequestMapping("allRoles")
    @ResponseBody
    public List<Map<String,Object>> queryAllRoles(){
        return roleService.queryAllRoles();
    }

    @RequestMapping("index")
    public String index(){
        return "role";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryRoolesByParams(@RequestParam(defaultValue = "1")Integer page,
                                                  @RequestParam(defaultValue = "10")Integer rows,
                                                  RoleQuery roleQuery){
        roleQuery.setPageNum(page);
        roleQuery.setPageSize(rows);

        return roleService.queryByParamsFroDataGrid(roleQuery);
    }

    @RequestMapping("save")
    @ResponseBody
    public ResultInfo AddRole(Role role){
        roleService.addRole(role);
        return success();
    }


    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteRole(Integer  id ){
        roleService.deleteRole(id);
        return success();
    }


    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateRole(Role role){
        roleService.updateRole(role);
        return success();
    }
}
