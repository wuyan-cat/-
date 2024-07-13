/**
 * z作者:无言
 * 版本:1.0
 * 2024-7-12 17:23
 */


package com.heima.wemedia.config;

import com.heima.wemedia.interceptor.WmTockenIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WmTockenIntercepter()).addPathPatterns("/**");
    }
}
