package com.dqit.common.algorithm.sort.impl;

import com.dqit.common.algorithm.sort.AbstractSortBase;

import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 22:12
 * @Description 二分插入排序算法
 */
public class BinaryInsertSortImpl<T> extends AbstractSortBase<T> {

    public BinaryInsertSortImpl(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    protected List<T> sortData(List<T> dataList, boolean reverse) {
        List<T> copyDataList = copyDataList(dataList);

        for (int i = 1; i < copyDataList.size(); ++i) {
            T current = copyDataList.get(i);
            int left = 0 , right = i - 1;

            // 定位插入位置
            while( left <= right){
                int mid = (left + right ) / 2;
                T target = copyDataList.get(mid);

                if(compare(current , target) > 0 ){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

            // 移动元素并放置元素
            int j = i ;
            while (j > left){
                copyDataList.set(j , copyDataList.get(j - 1 ));
                --j;
            }
            copyDataList.set(left , current);
        }

        return copyDataList;
    }
}
