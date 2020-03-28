package com.dqit.common.exception;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 19:29
 * @Description 必要参数未设置异常
 */
public class NecessaryParamLostException extends RuntimeException {

    public NecessaryParamLostException(){
        super("必要参数未设置异常，请检查参数配置");
    }

    public NecessaryParamLostException(String message){
        super(message);
    }
}
