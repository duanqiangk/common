package com.dqit.common.algorithm.sort.impl;

import com.dqit.common.algorithm.sort.AbstractSortBase;

import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 22:21
 * @Description
 */
public class SelectionSortImpl<T> extends AbstractSortBase<T> {

    protected SelectionSortImpl(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    protected List<T> sortData(List<T> dataList, boolean reverse) {
        //TODO : 选择排序算法实现
        return null;
    }
}
