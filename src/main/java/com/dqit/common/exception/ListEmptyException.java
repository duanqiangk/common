package com.dqit.common.exception;

/**
 * @Author qiang.duan
 * @Date 2020/4/11 17:12
 * @Description 列表元素空异常
 */
public class ListEmptyException extends RuntimeException{
    public ListEmptyException(){
        super("列表元素空异常");
    }

    public ListEmptyException(String message){
        super(message);
    }
}
