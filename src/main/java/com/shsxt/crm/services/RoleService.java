package com.shsxt.crm.services;

import com.shsxt.base.BaseService;
import com.shsxt.crm.db.dao.RoleMapper;
import com.shsxt.crm.po.Role;
import com.shsxt.crm.utils.AssertsUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleService extends BaseService<Role, Integer> {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 集合的二次封装  将map  对象  封装到list对象中
     * [
     * {
     * id: 1,
     * text: "系统管理员"
     * },
     * {
     * id: 2,
     * text: "销售主管"
     * },
     * {
     * id: 3,
     * text: "客户经理"
     * },
     * {
     * id: 14,
     * text: "技术经理"
     * }
     * ]
     *
     * @return
     */
    public List<Map<String, Object>> queryAllRoles() {
        //创建一个List对象   map对象
        List<Map<String, Object>> result = new ArrayList<>();
        //创建一个list 对象 list中是role对象
        List<Role> role = queryByParams(null);
        role.forEach(r -> {
            //创建一个hasmap
            Map<String, Object> map = new HashMap<>();
            //map的键是  id  值是   role的id
            map.put("id", r.getId());
            //map的键是  text  值是   role的name
            map.put("text", r.getRoleName());
            //将map添加到List《Map》中
            result.add(map);
        });
        return result;
    }


    /**
     * 角色添加方法
     *
     * @param role
     */
    public void addRole(Role role) {
        //参数校验
        checkRoleParams(role);
        role.setIsValid(1);
        role.setCreateDate(new Date());
        role.setUpdateDate(new Date());
        AssertsUtils.isTrue((0 == roleMapper.save(role)), "添加失败");

    }

    /**
     * 参数校验
     * 1.判断角色名称是否不为空 并且不存在
     *
     * @param role
     */
    private void checkRoleParams(Role role) {
        //判断角色名称是否为空
        AssertsUtils.isTrue(StringUtils.isBlank(role.getRoleName()), "角色名称不能为空");
        //根据角色名称取查询     如果查到的数据不等于空  判断是不是自己的
        Role role1 = roleMapper.queryByRoleName(role.getRoleName());
        //如果空不等于getId
        if (null!=role1){
            //id不为空就是修改  判断传过来的name的值查询到的对象是不是自己的id
            if (null!=role.getId()){
                AssertsUtils.isTrue(!(role.getId().equals(role1.getId())),"角色名称已存在");
            }else {
                //id为空是添加  判断 查询到的对象 的name是否存在
                AssertsUtils.isTrue(!(StringUtils.isBlank(role1.getRoleName())),"角色名称已存在");
            }
        }

        AssertsUtils.isTrue(StringUtils.isBlank(role.getRoleRemark()), "备注不能为空");
    }


    /**
     * 角色修改方法
     *
     * @param role
     */
    public void updateRole(Role role) {
        checkRoleParams(role);
        role.setUpdateDate(new Date());
        roleMapper.update(role);
    }

    /**
     * 删除方法
     * 1.参数判断
     * 2.根据传过来的id 查询 当前数据是否存在
     * 3.更新当前数据的is_viaid == 0
     *
     * @param id
     */
    public void deleteRole(Integer id) {
        Role role = queryById(id);
        AssertsUtils.isTrue(null == role, "删除的数据不存在");
        role.setIsValid(0);
        AssertsUtils.isTrue(0 == roleMapper.update(role), "删除失败");
    }
}
