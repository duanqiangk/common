package com.dqit.common.base;

import com.dqit.common.exception.ListEmptyException;
import com.dqit.common.exception.NecessaryParamLostException;

import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/4/11 17:09
 * @Description 先决条件
 */
public class Preconditions {
    /**
     * 检查数据是否为NULL，如果是NULL抛出异常
     *
     * @param data 数据
     * @param <T>  数据类型
     */
    public static <T> void checkNotNull(T data) {
        if (data == null) {
            throw new NecessaryParamLostException();
        }
    }

    /**
     * 检查数据是否为NULL ， 如果是抛出异常
     *
     * @param data 数据
     * @param message 异常信息
     * @param <T> 数据类型
     */
    public static <T> void checkNotNull(T data, String message) {
        if (data == null) {
            throw new NecessaryParamLostException(message);
        }
    }

    /**
     * 检查列表是否为空
     *
     * @param list 列表
     * @param <T> 数据类型
     */
    public static <T> void checkListNotEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new ListEmptyException();
        }
    }

    /**
     * 检查列表是否为空
     *
     * @param list 列表
     * @param message 异常信息
     * @param <T> 数据类型
     */
    public static <T> void checkListNotEmpty(List<T> list, String message) {
        if (list.isEmpty()) {
            throw new ListEmptyException(message);
        }
    }

}
