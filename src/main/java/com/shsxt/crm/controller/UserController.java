package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.model.UserModel;
import com.shsxt.crm.po.User;
import com.shsxt.crm.query.UserQuery;
import com.shsxt.crm.services.UserSerive;
import com.shsxt.crm.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserSerive userSerive;



    @RequestMapping("login")
    @ResponseBody
    public ResultInfo login(String userName, String userPwd) {
        UserModel login = userSerive.login(userName, userPwd);
        return success(login);
    }


    @RequestMapping("exit")
    @ResponseBody
    public ResultInfo exit() {
        return success("退出成功");

    }

    /**
     * 修改密码
     *
     * @param request
     * @return
     */
    @RequestMapping("updatePassword")
    @ResponseBody
    public ResultInfo UpdateUserPassWord(HttpServletRequest request, String oldPassword, String newPassword, String confirmPassword) {
        userSerive.UpdateUserPassWord(LoginUserUtil.releaseUserIdFromCookie(request), oldPassword, newPassword, confirmPassword);
        return success("密码更新成功");
    }


    @RequestMapping("index")
    public String index(){
        return "user";
    }


    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryUserByParams(@RequestParam(defaultValue = "1") Integer page ,
                                                @RequestParam(defaultValue = "10") Integer rows,
                                                UserQuery userQuery){
        userQuery.setPageNum(page);
        userQuery.setPageSize(rows);
        return userSerive.queryByParamsFroDataGrid(userQuery);
    }

    /**
     * 保存方法
     * @param user
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public ResultInfo saveUser(User user){
        userSerive.saveUser(user);
        return success("更新成功");
    }

    /**
     * 修改方法
     * @param user
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateUser(User user){
        userSerive.updateUser(user);
        return success("更新成功");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo delateUser(Integer id){
        userSerive.delateUser(id);
        System.out.println("干什么啊");
        return success("删除成功");

    }

}
