package com.newplan.base.util.mail;

import java.util.Arrays;

/**
 * @author JoeTwan
 * @date 2021/9/20 22:14
 * @description 发送邮件类型
 */
public enum MailProtocolTypeEnum {
    /**
     * 无发送协议
     */
    NONE( 0 , "NONE"),
    /**
     * SMTP 协议
     */
    SMTP(1 , "SMTP"),
    ;

    private int code ;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    MailProtocolTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static MailProtocolTypeEnum codeOf(int code){
        return Arrays.stream(MailProtocolTypeEnum.values()).filter(item -> item.getCode() == code).findAny().orElse(NONE);
    }
}
