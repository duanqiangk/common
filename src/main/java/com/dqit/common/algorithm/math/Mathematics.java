package com.dqit.common.algorithm.math;

import com.dqit.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/4/11 17:05
 * @Description 数学常用操作
 */
public class Mathematics {

    public static <T> T max(List<T> list, Comparator<T> comparator) {
        Preconditions.checkNotNull(list);
        Preconditions.checkListNotEmpty(list);

        T max = list.get(0);
        for (int i = 1; i < list.size(); ++i) {
            if (comparator.compare(list.get(i), max) >= 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static <T> T min(List<T> list, Comparator<T> comparator) {
        Preconditions.checkNotNull(list);
        Preconditions.checkListNotEmpty(list);

        T min = list.get(0);
        for (int i = 1; i < list.size(); ++i) {
            if (comparator.compare(min, list.get(i)) >= 0) {
                min = list.get(i);
            }
        }
        return min;
    }

    /**
     * 多个数字的最大公约数
     *
     * @param dataList 数据列表
     * @return 最大公约数
     */
    public static Integer gcd(List<Integer> dataList){
        return Numbers.gcd(dataList);
    }

    /**
     * 两个数的最大公约数
     *
     * @param a 数字A
     * @param b 数字B
     * @return 最大公约数
     */
    public static Integer gcd(Integer a , Integer b){
        return Numbers.gcd(a , b);
    }

    /**
     * 两个数的最小公倍数
     *
     * @param a 数字A
     * @param b 数字B
     * @return 最小公倍数
     */
    public static Integer lcm(Integer a , Integer b){
        return Numbers.lcm(Lists.newArrayList(a ,b));
    }

    /**
     * n个数字的最小公倍数
     *
     * @param dataList 数字列表
     * @return 最小公倍数
     */
    public static Integer lcm (List<Integer> dataList){
        return Numbers.lcm(dataList);
    }


}
