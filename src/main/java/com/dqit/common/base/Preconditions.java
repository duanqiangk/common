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
    public static<T> void checkNotNull(T data){
        if(data == null){
            throw new NecessaryParamLostException();
        }
    }

    public static<T> void checkNotNull (T data , String message){
        if (data == null){
            throw new NecessaryParamLostException(message);
        }
    }

    public static<T> void checkListNotEmpty(List<T> list){
        if(list.isEmpty()){
            throw new ListEmptyException();
        }
    }

    public static<T> void checkListNotEmpty(List<T> list , String message){
        if(list.isEmpty()){
            throw new ListEmptyException(message);
        }
    }
}
