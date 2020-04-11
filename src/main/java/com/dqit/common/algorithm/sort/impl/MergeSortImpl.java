package com.dqit.common.algorithm.sort.impl;

import com.dqit.common.algorithm.sort.AbstractSortBase;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 22:19
 * @Description 归并排序
 */
public class MergeSortImpl<T> extends AbstractSortBase<T> {

    public MergeSortImpl(Comparator<T> comparator) {
        super(comparator);
    }

    private void mergeSort(List<T> dataList, int low, int high, boolean reverse) {
        if (low == high) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(dataList, low, mid, reverse);
        mergeSort(dataList, mid + 1, high, reverse);

        //merge
        List<T> leftList = dataList.subList(low, mid + 1);
        List<T> rightList = dataList.subList(mid + 1, high + 1);
        List<T> targetList = Lists.newArrayList();


        int leftIndex = 0, rightIndex = 0;
        while (true) {
            if (leftIndex >= leftList.size() || rightIndex >= rightList.size()) {
                while (rightIndex < rightList.size()) {
                    targetList.add(rightList.get(rightIndex++));
                }
                while (leftIndex < leftList.size()) {
                    targetList.add(leftList.get(leftIndex++));
                }
                break;
            }
            T leftData = leftList.get(leftIndex);
            T rightData = rightList.get(rightIndex);
            boolean cmp = compare(rightData, leftData, reverse);

            if (cmp) {
                ++leftIndex;
                targetList.add(leftData);
                continue;
            }
            ++rightIndex;
            targetList.add(rightData);
        }
        for(int i =0  ;i < targetList.size() ; ++i){
            dataList.set(low + i , targetList.get(i));
        }
    }

    @Override
    protected List<T> sortData(List<T> dataList, boolean reverse) {
        List<T> result = Lists.newArrayList(dataList);
        mergeSort(result, 0, result.size() - 1, reverse);
        return result;
    }
}
