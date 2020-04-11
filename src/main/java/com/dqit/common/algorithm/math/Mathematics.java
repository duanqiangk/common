package com.dqit.common.algorithm.math;

import com.dqit.common.base.Preconditions;

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
}
