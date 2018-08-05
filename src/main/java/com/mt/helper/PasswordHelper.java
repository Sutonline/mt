package com.mt.helper;

import org.springframework.util.DigestUtils;

/**
 * @author yongkang.zhang
 * created at 05/08/2018
 */
public class PasswordHelper {

    public static String encrypt(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
