package com.jin.arithmetic.sort;

/**
 * 希尔排序
 *
 * @author jinpeng
 * @date 2019/7/25.
 */
public class ShellSort extends SortService {

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        Comparable[] arr = getArray();
        sort.sort(arr);
        sort.show(arr);
    }

    // ????????????
    @Override
    public void sort(Comparable[] array) {
        int n = array.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
                    exch(array, j, j - h);
                }
                h = h / 3;
            }
        }
    }
}
