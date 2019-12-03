package com.louyh.m.config;

import com.louyh.m.interceptor.LoginInterceptor;
import com.louyh.m.interceptor.RecordInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(new LoginInterceptor());
        // 配置拦截的路径
        ir.addPathPatterns("/admin/**");
        // 配置不拦截的路径
//        ir.excludePathPatterns("/**");
        InterceptorRegistration re =registry.addInterceptor(new RecordInterceptor());// 日志信息的保存
//        re.addPathPatterns("/**");
    }
}