package com.jin.arithmetic.sort;

/**
 * 快排
 *
 * @author jinpeng
 * @date 2019/7/31.
 */
public class QuickSort extends SortService {

    public static void main(String[] args) {
        Comparable[] arr = getArray();
        SortAdapt adapt = new SortAdapt(new QuickSort());
        adapt.exe(arr);
    }

    @Override
    public void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int p = partition(arr, lo, hi);
        sort(arr, lo, p - 1);
        sort(arr, p + 1, hi);
    }

    private int partition(Comparable[] arr, int lo, int hi) {
        Comparable v = arr[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(arr[++i], v)) if (i == hi) break;
            while (less(v, arr[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(arr, i, j);
        }
        exch(arr, lo, j);
        return j;
    }
}
