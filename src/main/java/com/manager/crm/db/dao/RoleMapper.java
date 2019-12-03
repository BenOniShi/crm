package com.manager.crm.db.dao;

import com.manager.base.BaseMapper;
import com.manager.crm.po.Role;

public interface RoleMapper extends BaseMapper<Role,Integer> {


   public Role queryByRoleName(String roleName);
}