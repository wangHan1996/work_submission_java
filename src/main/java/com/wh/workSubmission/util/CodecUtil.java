package com.wh.workSubmission.util;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class CodecUtil {
    /**
     * 设置“盐值”
     */
    private static final String SALT = "haoigu469gwg6";

    public static String createUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    /**
     * 加密
     *effe
     *
     */
    public static String ecvrypt(String pwd) {
        String base = pwd + "/" + SALT;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
