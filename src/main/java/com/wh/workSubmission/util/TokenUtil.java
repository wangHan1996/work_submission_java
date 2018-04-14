package com.wh.workSubmission.util;

import com.wh.workSubmission.exception.WorkException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class TokenUtil {
    /**
     * 从请求头中获得token
     */
    public static String getToken(HttpServletRequest httpServletRequest) {
      String token = httpServletRequest.getHeader("token");
      if (StringUtils.isEmpty(token)) {
          throw new WorkException("未登录");
      }
        return token;
    }
}
