package com.newplan.base.constant;

import java.util.Arrays;

/**
 * @author JoeTwan
 * @date 2021/9/5 12:43
 * @description HttpResponse code
 */
public enum HttpResponseCodeEnum {
    /**
     * 无效响应
     */
    INVALID_RESPONSE(-1, "无效响应码"),
    /**
     * 请求成功
     */
    SUCCESS(0, "请求成功"),
    /**
     * 系统逻辑错误
     */
    LOGIC_ERROR(101, "系统出错啦，请稍后再试"),
    /**
     * 服务器错误
     */
    SERVER_ERROR(102, "系统出错啦，请稍后再试"),
    /**
     * 请求参数错误
     */
    PARAM_EXCEPTION(201, "系统出错啦，请稍后再试"),
    /**
     * 网络错误
     */
    NETWORK_EXCEPTION(202 , "网络不稳定，请稍后再试")

    ;

    /**
     * 状态码
     */
    private final int code;
    /**
     * 描述信息
     */
    private final String msg;

    HttpResponseCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 根据状态码获得Enum实体
     *
     * @param code 响应码
     * @return Enum实体
     */
    public static HttpResponseCodeEnum codeOf(int code) {
        return Arrays.stream(HttpResponseCodeEnum.values()).filter(item -> item.code == code).findAny().orElse(INVALID_RESPONSE);
    }


}
