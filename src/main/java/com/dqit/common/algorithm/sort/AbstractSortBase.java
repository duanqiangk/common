package com.dqit.common.algorithm.sort;

import com.dqit.common.exception.NecessaryParamLostException;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 20:23
 * @Description 排序抽象类，实现公共方法
 */
public abstract class AbstractSortBase<T> implements SortFunctional<T>{

    private Comparator<T> comparator;

    protected AbstractSortBase(Comparator<T> comparator){
        this.comparator = comparator;
    }

    protected List<T> copyDataList(List<T> dataList){
        return Lists.newArrayList(dataList);
    }

    /**
     * 排序具体实现方法
     *
     * @param dataList 数据列表
     * @param reverse 反向标志
     * @return 排序后的数据列表
     */
    protected abstract List<T> sortData(List<T> dataList, boolean reverse);

    /**
     * 比较数据列表中的某2个数据大小
     *
     * @param a 前参数
     * @param b 后参数
     * @return 使用方提供的compare结果
     */
    protected int compare(T a, T b){
        return this.comparator.compare(a,b);
    }

    /**
     * 重新设置比较函数
     *
     * @param comparator 比较方法对象
     * @return this
     */
    @Override
    public SortFunctional<T> resetComparable(Comparator<T> comparator) {
        this.comparator = comparator;
        return this;
    }

    /**
     * 根据设定的compareble定向排序
     *
     * @param dataList 数据列表
     * @return 排序后的数据列表
     */
    @Override
    public List<T> sort(List<T> dataList) {
        Preconditions.checkNotNull(dataList);
        checkComparable();
        return sortData(dataList, false);
    }

    /**
     * 根据设定的comparable 反向排序
     *
     * @param dataList 数据列表
     * @return 反向排序后的数据列表
     */
    @Override
    public List<T> reverseSort(List<T> dataList) {
        Preconditions.checkNotNull(dataList);
        checkComparable();
        return sortData(dataList, true);
    }

    /**
     * 检查 Comparable 是否设定
     */
    private void checkComparable() {
        if (this.comparator == null) {
            throw new NecessaryParamLostException();
        }
    }
}
