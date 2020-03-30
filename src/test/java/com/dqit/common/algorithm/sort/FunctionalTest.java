package com.dqit.common.algorithm.sort;

import com.dqit.common.algorithm.sort.impl.BinaryInsertSortImpl;
import com.dqit.common.algorithm.sort.impl.QuickSortImpl;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author qiang.duan
 * @Date 2020/3/28 20:50
 * @Description
 */
public class FunctionalTest {

    @Test
   public void functionalTest(){

        SortFunctional<Integer> integerBubbleSort = new QuickSortImpl<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        List<Integer> list = Lists.newArrayList(5,1,2,3,4,8,9,6,4,5,1,2,5);
//        List<Integer> list = Lists.newArrayList(5,3,7,6,4,1,0,2,9,10,8);
        System.out.println(integerBubbleSort.sort(list));
    }

    @Test
    public void collectionsSort(){
        List<Integer> list = Lists.newArrayList(5,1,2,3,4,8,9,6,4,5,1,2,5);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);
    }

}
