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

    public QuickSortImpl(Comparator<T> comparator) {
        super(comparator);
    }

    private void swap(List<T> dataList, int left, int right) {
        T temp = dataList.get(left);
        dataList.set(left, dataList.get(right));
        dataList.set(right, temp);
    }

    private void quickSort(List<T> dataList, int left, int right) {
        if (left >= right) {
            return;
        }
        int low = left, high = right;
        T mark = dataList.get(left);

        while (low < high) {
            while (low < high && compare(mark, dataList.get(high)) <= 0) {
                --high;
            }
            swap(dataList, low, high);
            while (low < high && compare(mark, dataList.get(low)) >= 0) {
                ++low;
            }
            swap(dataList, low, high);
        }

        quickSort(dataList, left, low - 1);
        quickSort(dataList, low + 1, right );
    }

    @Override
    public List<T> sortData(List<T> dataList, boolean reverse) {
        List<T> copyDataList = copyDataList(dataList);
        quickSort(copyDataList, 0, copyDataList.size() - 1);
        return copyDataList;
    }
}
