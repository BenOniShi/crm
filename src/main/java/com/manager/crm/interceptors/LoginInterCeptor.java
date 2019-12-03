package com.manager.crm.interceptors;

import com.manager.crm.services.UserSerive;
import com.manager.crm.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器    继承 HandlerInterceptorAdapter
 * 重写   preHandle 方法
 */

public class LoginInterCeptor extends HandlerInterceptorAdapter  {
    @Autowired
    private UserSerive userSerive;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取cookie中的id
        Integer id = LoginUserUtil.releaseUserIdFromCookie(request);
        System.out.println(request.getContextPath());
        System.out.println(id);
        System.out.println(request.getSession().getServletContext().getContextPath());
        System.out.println(request.getSession().getServletContext().getRealPath("/"));
        //如果cookie中没有id   或者  未查询到id
        if (id==null||id==0||userSerive.queryById(id)==null){
        //   重定向到登陆界面
            response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/index");
            //返回一个false  不放行
            return  false;
        }
        return true;
    }
}
