package com.shsxt.crm.controller;

import com.shsxt.base.exceptions.ParamsException;
import com.shsxt.crm.services.UserSerive;
import com.shsxt.crm.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserSerive userSerive;

    /**
     * 登陆界面
     *
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        request.setAttribute("ctx", request.getContextPath());
        return "index";
    }


    @RequestMapping("index1")
    public String index1(HttpServletRequest request) {
        request.setAttribute("ctx", request.getContextPath());
        if (2>1){
            throw new ParamsException("表达式异常");
        }
        return "index1";
    }


    /**
     * index 登陆转发到main
     *
     * @param request
     * @return
     */
    @RequestMapping("main")
    public String main(HttpServletRequest request) {
        //获取存在cookie中的id
        Integer id = LoginUserUtil.releaseUserIdFromCookie(request);
        System.out.println(id);
        //   根据userId查询 user对象
        request.setAttribute("user", userSerive.queryById(id));
        request.setAttribute("ctx", request.getContextPath());
        return "main";
    }
}
