package com.dqit.common.algorithm.sort;

import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 20:08
 * @Description 排序抽象类
 */
public interface SortFunctional<T> {
    SortFunctional<T> resetComparable(Comparator<T> comparator);
    List<T> sort(List<T> dataList);
    List<T> reverseSort(List<T> dataList);
}
