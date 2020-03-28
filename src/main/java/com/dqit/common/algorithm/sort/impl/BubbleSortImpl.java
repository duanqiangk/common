package com.dqit.common.algorithm.sort.impl;

import com.dqit.common.algorithm.sort.AbstractSortBase;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 21:02
 * @Description 冒泡排序具体实现方法
 */
public class BubbleSortImpl<T> extends AbstractSortBase<T> {

    public BubbleSortImpl(Comparator<T> comparator) {
        super(comparator);
    }

    /**
     * 判断是否互换位置,默认从小到大排序
     *
     * @param compareResult 比较结果
     * @param reverse       反向标志
     * @return 是否交换
     */
    private boolean exchange(int compareResult, boolean reverse) {
        return (compareResult < 0 && reverse) || (compareResult > 0 && !reverse);
    }

    /**
     * 冒泡排序实现方法
     *
     * @param dataList 数据列表
     * @param reverse  反向标志
     * @return 排序结果
     */
    @Override
    protected List<T> sortData(List<T> dataList, boolean reverse) {
        List<T> alterDataList = copyDataList(dataList);
        int length = alterDataList.size();

        for (int i = 0; i < length; ++i) {
            boolean changePosition = false;
            for (int j = 0; j < length - i - 1; ++j) {
                T current = alterDataList.get(j);
                T next = alterDataList.get(j + 1);
                int compare = compare(current, next);

                if (exchange(compare, reverse)) {
                    alterDataList.set(j, next);
                    alterDataList.set(j + 1, current);
                    changePosition = true;
                }
            }
            //改进方案，如果一次遍历中没有交换过元素位置，那么就已经排序好了
            if (!changePosition) {
                break;
            }
        }
        return alterDataList;
    }

}
