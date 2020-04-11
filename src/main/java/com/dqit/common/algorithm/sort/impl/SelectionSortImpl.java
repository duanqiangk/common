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

    public SelectionSortImpl(Comparator<T> comparator) {
        super(comparator);
    }

    private void swap(List<T> dataList , int left , int right){
        T temp = dataList.get(left);
        dataList.set(left , dataList.get(right));
        dataList.set(right , temp);
    }

    @Override
    protected List<T> sortData(List<T> dataList, boolean reverse) {
        List<T> copyDataList = copyDataList(dataList);

        for(int i = 0 ; i < copyDataList.size() ; ++i ){
            int index = i ;

            for(int j = i + 1 ; j < copyDataList.size() ; ++j ){
                T target = copyDataList.get(j);
                if(compare(copyDataList.get(index) ,target  , reverse)){
                    index = j;
                }
            }
            swap(copyDataList , i , index);
        }
        return copyDataList;
    }
}
