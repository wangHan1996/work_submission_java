package com.wh.workSubmission.exception;

import com.wh.workSubmission.dto.Response;
import com.wh.workSubmission.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(WorkException.class)
    public Response handleWorkException(WorkException e) {
        logger.error("出现自定义异常：  {}", e.getMessage());
        if (e.getMessage().equals("未登录") || e.getMessage().equals("权限不足")) {
            return ResponseUtil.error("401", e.getMessage());
        }
        return ResponseUtil.error("600", e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        logger.error("系统异常", e);
        return ResponseUtil.error("500", e.getMessage());
    }
}
