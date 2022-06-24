package com.ahzx.baohanapi.common.config;

import com.ahzx.baohanapi.common.Interceptor.SignInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author xiehd
 * @Date 2022 06 24
 **/
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private SignInterceptor signInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(signInterceptor).addPathPatterns("/**") //所有请求都需要进行保温签名sign
                .excludePathPatterns("/html/*","/js/*");//排除html/js目录
    }

}
