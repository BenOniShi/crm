package com.manager.crm.db.dao;

import com.manager.base.BaseMapper;
import com.manager.crm.po.User;


public interface UserMapper extends BaseMapper<User, Integer> {
    /**
     * 根据传入的用户名查询user对象
     * @param userName
     * @return
     */
    public User queryUserByUserName(String userName);



}