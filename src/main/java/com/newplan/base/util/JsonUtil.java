package com.newplan.base.util;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author JoeTwan
 * @date 2021/9/5 14:01
 * @description JSON 常用辅助类
 */
public class JsonUtil {

    public static <T> String toJsonString(T object) {
        return JSON.toJSONString(object);
    }

    public static <T> T toObject(String jsonString, Class<T> tClass) {
        return JSON.parseObject(jsonString, tClass);
    }

    public static <T> List<T> toObjectList(String jsonString, Class<T> tClass) {
        return JSON.parseArray(jsonString, tClass);
    }
}
