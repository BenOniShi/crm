package com.manager.crm.services;

import com.manager.base.BaseService;
import com.manager.crm.db.dao.UserMapper;
import com.manager.crm.db.dao.UserRoleMapper;
import com.manager.crm.model.UserModel;
import com.manager.crm.po.User;
import com.manager.crm.po.UserRole;
import com.manager.crm.utils.AssertsUtils;
import com.manager.crm.utils.Md5Util;
import com.manager.crm.utils.UserIDBase64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserSerive extends BaseService<User, Integer> {

    //定义正则表达式
    private Pattern p = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$");



    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    public UserModel login(String userName, String userPwd) {
        /**
         * 1.参数校验
         * 2.根据用户名查询用户记录
         *          存在
         *                  判断密码
         */


        //参数校验
        checkLoginParams(userName, userPwd);
        //返回一个user对象  判断user的参数
        User user = userMapper.queryUserByUserName(userName);
        System.out.println(user);
        AssertsUtils.isTrue(null == user, "该用户不存在");
        AssertsUtils.isTrue(0 == user.getIsValid(), "该用户已注销");
        AssertsUtils.isTrue(!(Md5Util.encode(userPwd).equals(user.getUserPwd())), "密码错误");
        //返回一个userModel对象bulidUserInfo 方法
        return bulidUserInfo(user);

    }

    /**
     * 创建一个userModel对象
     *
     * @param user
     * @return
     */
    private UserModel bulidUserInfo(User user) {
        UserModel userModel = new UserModel();
        //加密userId
        userModel.setIdStr(UserIDBase64.encoderUserID(user.getId()));
        userModel.setUserName(user.getUserName());
        userModel.setTrueName(user.getTrueName());
        //返回一个userModel对象
        return userModel;
    }


    /**
     * 参数判断方法 断言   判断
     *
     * @param userName
     * @param userPwd
     */
    private void checkLoginParams(String userName, String userPwd) {
        //isTrue（表达式 ，  放入的信息）
        AssertsUtils.isTrue(StringUtils.isBlank(userName), "用户名不能为空");
        AssertsUtils.isTrue(StringUtils.isBlank(userPwd), "用户密码不能为空");


    }

    /**
     * 修改密码
     *
     * @param userId
     * @param OldPassWord
     * @param NewPassWord
     * @param confirmPassWord
     * @return
     */
    public void UpdateUserPassWord(Integer userId, String OldPassWord, String NewPassWord, String confirmPassWord) {
        /**
         * 参数校验
         *          新密码  一致
         *          数据库密码  与 新密码一致
         *
         */
        checkPassWord(OldPassWord, NewPassWord, confirmPassWord);
        //根据userid查询user对象
        User user = userMapper.queryById(userId);
        //根据数据库中的密码 与 要修改的密码进行比对
        System.out.println(user.getUserPwd());
        AssertsUtils.isTrue(!(user.getUserPwd().equals(Md5Util.encode(OldPassWord))), "原密码输入错误");
        user.setUserPwd(Md5Util.encode(NewPassWord));
        AssertsUtils.isTrue(userMapper.update(user) == 0, "密码更新失败");


    }

    private void checkPassWord(String oldPassWord, String newPassWord, String confirmPassWord) {
        AssertsUtils.isTrue(StringUtils.isBlank(oldPassWord), "原始密码不能为空");
        AssertsUtils.isTrue(StringUtils.isBlank(newPassWord), "新密码不能为空");
        AssertsUtils.isTrue(StringUtils.isBlank(confirmPassWord), "请再次确认密码");
        AssertsUtils.isTrue(!(newPassWord.equals(confirmPassWord)), "密码输入不正确");
        AssertsUtils.isTrue((newPassWord.equals(oldPassWord)), "新密码与原密码一致");
    }


    /**
     * 保存方法
     *
     * @param user
     */
    public void saveUser(User user) {

        //参数校验
        checkUserParams(user);
        User tempUser = userMapper.queryUserByUserName(user.getUserName());
        //判断用户名是否存在
        AssertsUtils.isTrue(null != tempUser, "用户名已存在");
        //设置默认密码  加密
        user.setUserPwd(Md5Util.encode("123456"));
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        AssertsUtils.isTrue(!(p.matcher(user.getPhone()).matches()), "手机号格式不正确");
        AssertsUtils.isTrue(save(user) == 0, "添加失败");


        /**
         * 角色关联方法
         */
        relationUserRole(user.getId(), user.getRoleIds());
    }

    /**
     * 角色关联
     * 1. 先删除用户已有的角色   再添加新的角色
     *
     * @param id
     * @param roleIds
     */
    private void relationUserRole(Integer id, List<Integer> roleIds) {
        /*
        1.参数校验
        删除   原有的角色
         */
        //先查询 userid 下的角色数量   如果数量大于0 删除已有的数量
        int count = userRoleMapper.counUserRolesByUserId(id);
        if (count > 0) {
            //如果count 大于0  删除userid对应的角色  如果  count 和删除的记录数不一样 删除失败
            AssertsUtils.isTrue(userRoleMapper.deleteByUserId(id) != count, "删除失败");
        }
        if (roleIds.size() > 0) {
            //创建一个 用户角色对象的list
            List<UserRole> list = new ArrayList<>();
            //遍历roleids
            roleIds.forEach(r -> {
                //实列化一个userRole
                UserRole userRole = new UserRole();
                //设置userid
                userRole.setUserId(id);
                //设置角色id
                userRole.setRoleId(r);
                //将userRole 添加到 list中
                list.add(userRole);
            });
            //如果   插入后的数据返回数量不等于 前台传过来的 roleids 的数量  添加失败
            AssertsUtils.isTrue((userRoleMapper.saveBatch(list) != roleIds.size()), "添加用户角色失败");
        }


    }


    private void checkUserParams(User user) {
        AssertsUtils.isTrue(StringUtils.isBlank(user.getUserName()), "用户名不能为空");
    }

    /**
     * 更新方法、
     * 1.参数校验
     * 2.查询用户名是否被占用
     * 3.更新
     *
     * @param user
     */
    public void updateUser(User user) {
        checkUserParams(user);
        User tempUser = userMapper.queryUserByUserName(user.getUserName());
        //先判断  tempUser是否为空  如果不为空 说明查到了 然后判断是否是自己自身  如果不是自身 说明被占用
        AssertsUtils.isTrue(null != tempUser && !(tempUser.getId().equals(user.getId())), "用户名已被使用");
        user.setUpdateDate(new Date());
        AssertsUtils.isTrue(!(p.matcher(user.getPhone()).matches()), "手机号格式不正确");
        AssertsUtils.isTrue(update(user) == 0, "更新失败");

        /**
         * 角色关联方法z
         */
        relationUserRole(user.getId(), user.getRoleIds());

    }

    /**
     * 删除方法
     * 1.改变角色的  is_vailid    将角色表中的数据删除
     */

    public void delateUser(Integer id) {
        System.out.println(id);
        AssertsUtils.isTrue(null == id || null == queryById(id), "用户不存在");
        //查询用户角色表中的数量 如果存在 删除
        int count = userRoleMapper.queryCountByUserId(id);
        if (count>0){
            //如果删除的记录和查询的记录返回结果不一致    删除失败
           AssertsUtils.isTrue((userRoleMapper.deleteByUserId(id)!=count),"操作失败");
        }
        //该表user中的 is_vailId的值为0
        userMapper.delete(id);


    }




}
