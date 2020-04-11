package com.dqit.common.algorithm.math;

import com.dqit.common.base.Preconditions;

import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/4/11 17:22
 * @Description
 */
public class Numbers {

    /**
     * 多个数字的最大公约数
     *
     * @param dataList 数据列表
     * @return 最大公约数
     */
    public static Integer gcd(List<Integer> dataList){
        Preconditions.checkNotNull(dataList);
        Preconditions.checkListNotEmpty(dataList);

        int temp = dataList.get(0);
        for(int i = 1 ; i < dataList.size() ; ++ i ){
            temp = gcd(temp , dataList.get(i));
        }
        return temp;
    }

    /**
     * 求两个数的最大公约数
     *
     * @param a 数字A
     * @param b 数字B
     * @return 最大公约数
     */
    public static Integer gcd(Integer a , Integer b){
        Integer maxValue = Math.max(a , b);
        Integer minValue = Math.min(a, b);

        while (minValue != 1){
            Integer temp = maxValue % minValue;
            maxValue = minValue;
            minValue = temp;
        }
        return maxValue;
    }

    /**
     * 最小公倍数算法
     * 两个数的乘积 = 最大公约数 * 最小公倍数
     *
     * @param integerList n个数字
     * @return 最小公倍数
     */
    public static Integer lcm(List<Integer> integerList){
        Preconditions.checkNotNull(integerList);
        Preconditions.checkListNotEmpty(integerList);

        int temp = integerList.get(0);
        for (int i = 1 ; i < integerList.size() ; ++i ){
            int value = integerList.get(i);
            int gcd = gcd(temp , value);
            temp = value / gcd * temp;
        }
        return temp;
    }
}
