package com.jin.arithmetic.sort;

/**
 * 插入排序
 *
 * @author jinpeng
 * @date 2019/7/24.
 */
public class InsertSort extends SortService {

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        Comparable[] arr = getArray();
        sort.sort(arr);
        sort.show(arr);
    }

    @Override
    public void sort(Comparable[] array) {
        int compNum = 0, swapNum = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                exch(array, j, j - 1);
            }
            /*for (int j = i; j > 0; j--) {
                if (less(array[j], array[j - 1])) exch(array, j, j - 1);
                else break;
            }*/
        }
    }
}
