package com.dqit.common.algorithm.sort.impl;

import com.dqit.common.algorithm.sort.AbstractSortBase;

import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 22:20
 * @Description
 */
public class QuickSortImpl<T> extends AbstractSortBase<T> {

    protected QuickSortImpl(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    protected List<T> sortData(List<T> dataList, boolean reverse) {
        //TODO : 快速排序算法实现
        return null;
    }
}
