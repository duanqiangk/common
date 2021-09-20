package com.newplan.base.dto;

import com.newplan.base.constant.HttpResponseCodeEnum;
import com.newplan.base.util.JsonUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JoeTwan
 * @date 2021/9/5 12:38
 * @description Http接口通用返回实体
 */
@Data
public class HttpResult<T> implements Serializable {
    /**
     * 状态码
     */
    private int code;
    /**
     * 响应结果
     */
    private boolean success;
    /**
     * 返回结果
     */
    private T result;
    /**
     * 响应描述信息
     */
    private String message;

    private HttpResult(int code, boolean success, T result, String message) {
        this.code = code;
        this.success = success;
        this.result = result;
        this.message = message;
    }

    public static <T> HttpResult<T> success() {
        return success(null);
    }

    public static <T> HttpResult<T> success(T result) {
        return success(HttpResponseCodeEnum.SUCCESS.getCode(), result);
    }

    public static <T> HttpResult<T> success(int code, T result) {
        return success(code, null, result);
    }

    public static <T> HttpResult<T> success(int code, String msg) {
        return success(code, msg, null);
    }

    public static <T> HttpResult<T> success(int code, String msg, T result) {
        return new HttpResult<>(code, true, result, msg);
    }

    public static <T> HttpResult<T> fail() {
        return fail(HttpResponseCodeEnum.NETWORK_EXCEPTION.getCode());
    }

    public static <T> HttpResult<T> fail(int code) {
        return fail(code, HttpResponseCodeEnum.codeOf(code).getMsg());
    }

    public static <T> HttpResult<T> fail(String message) {
        return fail(HttpResponseCodeEnum.NETWORK_EXCEPTION.getCode(), message);
    }

    public static <T> HttpResult<T> fail(int code, String message) {
        return fail(code, message, null);
    }

    public static <T> HttpResult<T> fail(int code, String msg, T result) {
        return new HttpResult<T>(code, false, result, msg);
    }

    @Override
    public String toString(){
        return JsonUtil.toJsonString(this);
    }
}
