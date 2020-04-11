package com.dqit.common.algorithm.sort.impl;

import com.dqit.common.algorithm.sort.AbstractSortBase;

import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 22:22
 * @Description 希尔排序算法实现
 */
public class ShellSortImpl<T> extends AbstractSortBase<T> {

    public ShellSortImpl(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    protected List<T> sortData(List<T> dataList, boolean reverse) {
        List<T> copyDataList = copyDataList(dataList);
        int gap = copyDataList.size() ;
        do {
            gap /= 2;
            for (int i = 0 ; i < gap ; ++i){
                for(int j = i + gap ; j < copyDataList.size() ; j += gap) {
                    T temp = copyDataList.get(j);
                    int prevIndex = j - gap;
                    while (prevIndex >= 0 && compare(copyDataList.get(prevIndex), temp, reverse)) {
                        copyDataList.set(prevIndex + gap, copyDataList.get(prevIndex));
                        prevIndex -= gap;
                    }
                    copyDataList.set(prevIndex + gap, temp);
                }
            }
        }while (gap != 1);

        return copyDataList;
    }
}
