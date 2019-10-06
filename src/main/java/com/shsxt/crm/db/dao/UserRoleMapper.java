package com.shsxt.crm.db.dao;

import com.shsxt.base.BaseMapper;
import com.shsxt.crm.po.UserRole;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper  extends BaseMapper<UserRole,Integer> {

    /**
     * 统计用户id下的角色数量
     * @param id
     * @return
     */
    int counUserRolesByUserId (Integer id);

    /**
     * 根据用户id删除
     * @param id
     * @return
     */
    int deleteByUserId(Integer id);


    int queryCountByUserId(@Param(value = "userId") Integer userId);

}