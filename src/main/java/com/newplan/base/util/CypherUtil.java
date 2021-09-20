package com.newplan.base.util;

import com.google.common.collect.Maps;
import com.newplan.base.algorithm.encrypt.EncryptionService;
import com.newplan.base.algorithm.encrypt.Md5Encryption;
import com.newplan.base.math.MathUtil;

import java.util.Map;

/**
 * @author JoeTwan
 * @date 2021/9/5 13:43
 * @description
 */
public class CypherUtil {

    /**
     * 自定义加密算法名-MD5
     */
    private final static String KEY_MD5 = "md5";
    /**
     * 加密算法持久Map
     */
    private static Map<String , EncryptionService> encryptionServiceMap = Maps.newHashMap();

    static {
        encryptionServiceMap.put(KEY_MD5 , new Md5Encryption());
    }

    /**
     * 使用MD5加密算法加密
     *
     * @param message 加密明文
     * @return 加密密文
     */
    public static String encryptionMd5(String message) {
        return encryptionServiceMap.get(KEY_MD5).encryption(message);
    }

    /**
     * 使用MD5 加密方法加密th次
     *
     * @param message 明文
     * @param th      密文
     * @return 加密密文
     */
    public static String encryptionMd5Nth(String message, int th) {
        if (MathUtil.isNotPositive(th)) {
            return message;
        }
        for (int i = 0; i < th; ++i) {
            message = encryptionMd5(message);
        }
        return message;
    }
}
