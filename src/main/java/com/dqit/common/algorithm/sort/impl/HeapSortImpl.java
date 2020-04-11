package com.dqit.common.algorithm.sort.impl;

import com.dqit.common.algorithm.sort.AbstractSortBase;

import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 22:19
 * @Description 堆排序
 */
public class HeapSortImpl<T> extends AbstractSortBase<T> {

    public HeapSortImpl(Comparator<T> comparator) {
        super(comparator);
    }

    /**
     * change the position of index A & B
     *
     * @param heap 堆
     * @param indexA index of node A
     * @param indexB index of node B
     */
    private void swap(List<T> heap, int indexA, int indexB) {
        T temp = heap.get(indexA);
        heap.set(indexA, heap.get(indexB));
        heap.set(indexB, temp);
    }

    /**
     * 1 . build heap
     * 2 . heap adjust
     *
     * @param heap heap
     * @param reverse reverse flag
     */
    private void heapSort(List<T> heap, boolean reverse) {
        // 自底向上构建heap
        for (int i = heap.size() / 2 - 1; i >= 0; --i) {
            adjustHeap(heap, i, heap.size(), reverse);
        }

        // 每次移除堆顶元素并与最后元素交换位置 返回堆顶元素并调整
        for (int j = heap.size() - 1; j > 0; --j) {
            swap(heap, 0, j);
            adjustHeap(heap, 0, j, reverse);
        }
    }

    /**
     * adjust the heap
     *
     * @param heap heap
     * @param index adjust position
     * @param length the max length of heap
     * @param reverse reverse flag
     */
    private void adjustHeap(List<T> heap, int index, int length, boolean reverse) {
        T father = heap.get(index);

        // 循环平衡堆
        // 注： << 左移位运算符 比 + 运算符优先级低 需要括号处理
        for (int sonIndex = (index << 1) + 1; sonIndex < length; sonIndex = (sonIndex << 1) + 1) {
            // 选择左右子节点中最大的节点
            if (sonIndex + 1 < length && compare(heap.get(sonIndex + 1), heap.get(sonIndex), reverse)) {
                ++sonIndex;
            }
            // 比较节点值 如果没有交换直接退出循环
            if (compare(heap.get(sonIndex), father, reverse)) {
                swap(heap, index, sonIndex);
                index = sonIndex;
                continue;
            }
            break;
        }
    }

    @Override
    protected List<T> sortData(List<T> dataList, boolean reverse) {
        List<T> cpDataList = copyDataList(dataList);
        heapSort(cpDataList, reverse);
        return cpDataList;
    }
}
