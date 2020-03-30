package com.dqit.common.algorithm.sort.impl;

import com.dqit.common.algorithm.sort.AbstractSortBase;

import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 22:12
 * @Description 直接插入排序算法
 */
public class DirectInsertSortImpl<T> extends AbstractSortBase<T> {

    public DirectInsertSortImpl(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    protected List<T> sortData(List<T> dataList, boolean reverse) {
        List<T> cpList = copyDataList(dataList);

        for(int i = 1 ; i < cpList.size() ; ++ i ){
            int index = i ;
            // 要进入有序队列的元素
            T target = cpList.get(index);

            while (index > 0 ){
                T current = cpList.get(index - 1);
                int cmp = compare(target , current);
                if(stopCheck(cmp , reverse)){
                    break;
                }

                //将前面的元素复制到当前位置
                cpList.set(index , current);
                --index;
            }
            cpList.set(index , target);
        }
        return cpList;
    }

    /**
     * 是否停止遍历并插入当前位置
     *
     * @return 是否停止遍历标志
     */
    private boolean stopCheck(int compareResult, boolean reverse) {
        return (compareResult > 0 && !reverse) || (compareResult < 0 && reverse);
    }
}
