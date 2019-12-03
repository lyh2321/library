package com.louyh.m.interceptor;

import com.louyh.m.constant.Constant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 验证用户是否登陆
        String userInfostring = (String) request.getSession().getAttribute(Constant.USER_INFO);

        if (userInfostring == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login.do");
            return false;
        }
        return true;
    }
}
