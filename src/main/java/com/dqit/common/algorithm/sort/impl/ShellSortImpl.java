package com.dqit.common.algorithm.sort.impl;

import com.dqit.common.algorithm.sort.AbstractSortBase;

import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 22:22
 * @Description
 */
public class ShellSortImpl<T> extends AbstractSortBase<T> {

    protected ShellSortImpl(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    protected List<T> sortData(List<T> dataList, boolean reverse) {
        //TODO : 希尔排序算法实现
        return null;
    }
}
