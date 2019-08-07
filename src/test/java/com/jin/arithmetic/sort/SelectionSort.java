package com.jin.arithmetic.sort;

/**
 * 插入排序
 *
 * @author jinpeng
 * @date 2019/7/30.
 */
public class SelectionSort extends SortService {

    public static void main(String[] args) {
        Comparable[] integers = getArray();
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(integers);
        selectionSort.show(integers);
    }


    @Override
    public void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[min])) min = j;
            }
            exch(array, i, min);
        }
    }
}
