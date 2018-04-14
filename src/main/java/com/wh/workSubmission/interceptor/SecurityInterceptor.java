package com.wh.workSubmission.interceptor;

import com.wh.workSubmission.annotation.IgnoreSecurity;
import com.wh.workSubmission.exception.WorkException;
import com.wh.workSubmission.service.TokenService;
import com.wh.workSubmission.util.ResponseUtil;
import com.wh.workSubmission.util.TokenUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 用于检查 token 的拦截器
 */
@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object handler)
            throws Exception {
        // 从切点上获取目标方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 若目标方法忽略了安全性检查，则直接调用目标方法
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return true;
        }
        // 从请求头中获得token
        String token = TokenUtil.getToken(httpServletRequest);
        // 检查 token 有效性
        if (StringUtils.isEmpty(token) || !tokenService.checkToken(token)) {
            ResponseUtil.notLogin();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
