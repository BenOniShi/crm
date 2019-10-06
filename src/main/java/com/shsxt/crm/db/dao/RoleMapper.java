package com.shsxt.crm.db.dao;

import com.shsxt.base.BaseMapper;
import com.shsxt.crm.po.Role;

public interface RoleMapper extends BaseMapper<Role,Integer> {


   public Role queryByRoleName(String roleName);
}