package com.wh.workSubmission.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CorsInterceptor implements HandlerInterceptor {
    @Autowired
    private Environment env;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object o) {
        //这里填写你允许进行跨域的主机ip
        httpServletResponse.setHeader("Access-Control-Allow-Origin",
                env.getProperty("cors.Access-Control-Allow-Origin"));
        //允许的访问方法
        httpServletResponse.setHeader("Access-Control-Allow-Methods",
                env.getProperty("cors.Access-Control-Allow-Methods"));
        //Access-Control-Max-Age 用于 CORS 相关配置的缓存
        httpServletResponse.setHeader("Access-Control-Max-Age",
                env.getProperty("cors.Access-Control-Max-Age"));
        // 跨域允许包含的头
        httpServletResponse.setHeader("Access-Control-Allow-Headers",
                env.getProperty("cors.Access-Control-Allow-Headers"));
        // 是否允许带凭证的请求
        httpServletResponse.setHeader("Access-Control-Allow-Credentials",
                env.getProperty("cors.Access-Control-Allow-Credentials"));
        // 可以获得头中token和Date的信息
        httpServletResponse.setHeader("Access-Control-Expose-Headers",
                env.getProperty("cors.Access-Control-Expose-Headers"));
        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(200);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) {

    }
}
