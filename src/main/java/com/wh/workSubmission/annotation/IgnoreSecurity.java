package com.wh.workSubmission.annotation;

import java.lang.annotation.*;

/**
 * 忽略安全性检查
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreSecurity {
}
