package com.louyh.m.interceptor;


import com.alibaba.fastjson.JSON;
import com.louyh.m.domain.user.UserInfo;
import com.louyh.m.util.Utils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecordInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        UserInfo user = Utils.getUserInfo(httpServletRequest);
        if (user != null && user.getId() != null) {
//            Record record = new Record();
//            record.setId(null);
//            record.setIid(Utils.getuuid());
//            record.setCdate(Utils.now());
//            record.setUserid(user.getId());
//            record.setRemoteaddr(Utils.getRemoteAddr(httpServletRequest));
//            record.setUseragent(httpServletRequest.getHeader("user-agent"));
//            record.setDopath(httpServletRequest.getRequestURI());
//            record.setParams(JSON.toJSONString(httpServletRequest.getParameterMap()));
//            record.setMethod(httpServletRequest.getMethod());
//            // 异步保存日志
//            new RecordUtils.SaveThread(record).start();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
