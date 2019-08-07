package com.jin.arithmetic.sort;

/**
 * 自顶向下的归并排序
 *
 * @author jinpeng
 * @date 2019/7/25.
 */
public class MergerSort extends SortService {


    public static void main(String[] args) {
        Comparable[] arr = getArray();
        SortAdapt mergerAdapt = new SortAdapt(new MergerSort());
        mergerAdapt.exe(arr);
    }

    @Override
    public void sort(Comparable[] array) {
        aux = new Comparable[array.length];
        sort(array, 0, array.length - 1);
    }

    private void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merger(arr, lo, mid, hi);
    }

}
