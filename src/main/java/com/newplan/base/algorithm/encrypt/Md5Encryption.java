package com.newplan.base.algorithm.encrypt;

import lombok.extern.log4j.Log4j2;

import java.security.MessageDigest;

/**
 * @author JoeTwan
 * @date 2021/9/5 13:45
 * @description MD5 密码操作
 */
@Log4j2
public class Md5Encryption implements EncryptionService{
    /**
     * Md5 密码加密
     *
     * @param message 加密明文
     * @return 加密密文
     */
    @Override
    public String encryption(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] result = md.digest(message.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : result) {
                int sign = b & 255;
                String str = Integer.toHexString(sign);
                if (str.length() == 1) {
                    sb.append("0");
                }

                sb.append(str);
            }

            return sb.toString();
        } catch (Exception e) {
            log.error("cmd=Md5Encryption , encrypt code failed , param = {} , error = {}", message, e);
        }
        return null;
    }
}
