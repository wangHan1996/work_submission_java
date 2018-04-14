package com.wh.workSubmission.annotation;

import java.lang.annotation.*;

/**
 * 控制权限
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Access {
    String[] authorities() default {};
}
