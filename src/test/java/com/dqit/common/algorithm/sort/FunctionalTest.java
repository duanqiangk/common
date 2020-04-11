package com.dqit.common.algorithm.sort;

import com.dqit.common.algorithm.sort.impl.*;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 20:50
 * @Description
 */
public class FunctionalTest {
    private List<Integer> list1 = Lists.newArrayList(5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8);
    private List<Integer> list2 = Lists.newArrayList(5, 1, 2, 3, 4, 8, 9, 6, 4, 5, 1, 2, 5);

    /**
     * 希尔排序测试
     */
    @Test
    public void shellSortTest() {
        SortFunctional<Integer> sortAlgorithm = new ShellSortImpl<Integer>((o1, o2) -> o1 - o2);

        System.out.println(sortAlgorithm.sort(list1));
        System.out.println(sortAlgorithm.sort(list2));
    }

    /**
     * 冒泡排序测试
     */
    @Test
    public void bubbleSortTest(){
        SortFunctional<Integer> sortAlgorithm = new BubbleSortImpl<>((o1, o2) -> o1 - o2);

        System.out.println(sortAlgorithm.sort(list1));
        System.out.println(sortAlgorithm.sort(list2));
    }

    /**
     * 直接插入排序测试
     */
    @Test
    public void directInsertSortTest(){
        SortFunctional<Integer> sortAlgorithm = new DirectInsertSortImpl<>((o1, o2) -> o1 - o2);

        System.out.println(sortAlgorithm.sort(list1));
        System.out.println(sortAlgorithm.sort(list2));
    }

    /**
     * 二分插入排序测试
     */
    @Test
    public void binaryInsertSortTest(){
        SortFunctional<Integer> sortAlgorithm = new BinaryInsertSortImpl<>((o1, o2) -> o1 - o2);

        System.out.println(sortAlgorithm.sort(list1));
        System.out.println(sortAlgorithm.sort(list2));
    }

    /**
     * 归并排序测试
     */
    @Test
    public void mergeSortTest(){
        SortFunctional<Integer> sortAlgorithm = new MergeSortImpl<>((o1, o2) -> o1 - o2);

        System.out.println(sortAlgorithm.sort(list1));
        System.out.println(sortAlgorithm.sort(list2));
    }

    /**
     * 堆排序测试
     */
    @Test
    public void heapSortTest(){
        SortFunctional<Integer> sortAlgorithm = new HeapSortImpl<>((o1, o2) -> o1 - o2);

        System.out.println(sortAlgorithm.sort(list1));
        System.out.println(sortAlgorithm.sort(list2));
    }

    /**
     * 快速排序测试
     */
    @Test
    public void quickSortTest(){
        SortFunctional<Integer> sortAlgorithm = new QuickSortImpl<>((o1, o2) -> o1 - o2);

        System.out.println(sortAlgorithm.sort(list1));
        System.out.println(sortAlgorithm.sort(list2));
    }

    /**
     * 选择排序测试
     */
    @Test
    public void selectionSortTest(){
        SortFunctional<Integer> sortAlgorithm = new SelectionSortImpl<>((o1, o2) -> o1 - o2);

        System.out.println(sortAlgorithm.sort(list1));
        System.out.println(sortAlgorithm.sort(list2));
    }


    @Test
    public void bucketSortTest(){
        SortFunctional<Integer> sortAlgorithm = new BucketSortImpl<>((o1, o2) -> o1 - o2);

        System.out.println(sortAlgorithm.sort(list1));
        System.out.println(sortAlgorithm.sort(list2));
    }

    @Test
    public void countSortTest(){
        SortFunctional<Integer> sortAlgorithm = new CountSortImpl<>((o1, o2) -> o1 - o2);

        System.out.println(sortAlgorithm.sort(list1));
        System.out.println(sortAlgorithm.sort(list2));
    }

    @Test
    public void radixSortTest(){
        SortFunctional<Integer> sortAlgorithm = new RadixSortImpl<>((o1, o2) -> o1 - o2);

        System.out.println(sortAlgorithm.sort(list1));
        System.out.println(sortAlgorithm.sort(list2));
    }
}
