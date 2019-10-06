package com.shsxt.crm.db.dao;

import com.shsxt.base.BaseMapper;
import com.shsxt.crm.po.User;


public interface UserMapper extends BaseMapper<User, Integer> {
    /**
     * 根据传入的用户名查询user对象
     * @param userName
     * @return
     */
    public User queryUserByUserName(String userName);



}