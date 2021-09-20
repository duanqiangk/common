package com.newplan.base.math;

/**
 * @author JoeTwan
 * @date 2021/9/5 13:54
 * @description 数学常用操作
 */
public class MathUtil {


    public static boolean isPositive(Integer integer){
        return integer != null && integer > 0 ;
    }

    public static boolean isNotPositive(Integer integer){
        return integer != null && integer <= 0;
    }
}
