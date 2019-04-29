package com.coding.temp.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Zhang Yongei
 * @version 1.0
 * @description
 * @date 2019-03-21
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    /**
     * 拦截所有请求  过滤首页和登陆页
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login","/user/logout","/","/recording");
    }
}
