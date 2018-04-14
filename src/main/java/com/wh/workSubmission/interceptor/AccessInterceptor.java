package com.wh.workSubmission.interceptor;

import com.wh.workSubmission.annotation.Access;
import com.wh.workSubmission.exception.WorkException;
import com.wh.workSubmission.service.TokenService;
import com.wh.workSubmission.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class AccessInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object handler)
            throws Exception {
        // 从切点上获取目标方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Access access = method.getAnnotation(Access.class);
        if (access == null) {
            //如果注解为null，说明不需要拦截
            return true;
        }
        if (access.authorities().length > 0) {
            // 从cookie头中获得token
            String token = TokenUtil.getToken(httpServletRequest);
            String userType = tokenService.getUserType(token);
            // 如果权限配置不为空, 则取出配置值
            String[] authorities = access.authorities();
            for (String authority : authorities) {
                if (authority.equals(userType)) {
                    return true;
                }
            }
        }
        throw new WorkException("权限不足");
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
