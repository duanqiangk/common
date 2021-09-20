package com.newplan.base.algorithm.encrypt;

/**
 * @author JoeTwan
 * @date 2021/9/5 13:50
 * @description 密码服务接口
 */
public interface EncryptionService {
    /**
     * 加密操作
     *
     * @param message 加密明文
     * @return 加密密文
     */
    String encryption(String message);
}
