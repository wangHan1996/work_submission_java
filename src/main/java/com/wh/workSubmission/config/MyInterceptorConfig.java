package com.wh.workSubmission.config;

import com.wh.workSubmission.interceptor.AccessInterceptor;
import com.wh.workSubmission.interceptor.CorsInterceptor;
import com.wh.workSubmission.interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyInterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    public SecurityInterceptor securityInterceptor() {
        return new SecurityInterceptor();
    }

    @Bean
    public AccessInterceptor accessInterceptor() {
        return new AccessInterceptor();
    }

    @Bean
    public CorsInterceptor corsInterceptor() {
        return new CorsInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(securityInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(accessInterceptor()).addPathPatterns("/**");
    }


}
