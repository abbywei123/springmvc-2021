package com.yw.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断什么情况下登录
        HttpSession session =request.getSession();

        if (request.getRequestURI().contains("login")){
            return true;
        }

        if (request.getRequestURI().contains("goLogin")){
            return true;
        }

        if (session.getAttribute("userLoginInfo")!=null){
            return true;
        }

        //判断什么情况下没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
