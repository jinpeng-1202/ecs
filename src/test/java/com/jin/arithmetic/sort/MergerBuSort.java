package com.jin.arithmetic.sort;

/**
 * 自底向上的归并排序
 *
 * @author jinpeng
 * @date 2019/7/31.
 */
public class MergerBuSort extends SortService {

    public static void main(String[] args) {
        Comparable[] arr = getArray();
        SortAdapt adapt = new SortAdapt(new MergerBuSort());
        adapt.exe(arr);
    }

    @Override
    public void sort(Comparable[] array) {
        aux = new Comparable[array.length];
        for (int sz = 1; sz < array.length; sz = sz + sz) {
            for (int lo = 0; lo < array.length - sz; lo += sz + sz) {
                merger(array, lo, lo + sz - 1, Math.min(lo + sz + sz-1, array.length - 1));
            }
        }
    }
}
