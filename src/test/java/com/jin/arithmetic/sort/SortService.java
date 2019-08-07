package com.jin.arithmetic.sort;

import com.alibaba.fastjson.JSON;
import com.jin.design.proxy.jdkdynamic.cglib.HelloMethodInterceptor;
import org.springframework.cglib.proxy.Enhancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author jinpeng
 * @date 2019/7/24.
 */
public abstract class SortService {

    public static Comparable[] aux;

    public static void main(String[] args) {
        Comparable[] arr = getArray();
        Comparable[] arr2 = copy(arr);
        Comparable[] arr3 = copy(arr);

        /*SortAdapt insertAdapt = new SortAdapt(new InsertSort());
        insertAdapt.exe(arr);

        SortAdapt selectAdapt = new SortAdapt(new SelectionSort());
        selectAdapt.exe(arr2);

        SortAdapt mergerAdapt = new SortAdapt(new MergerSort());
        mergerAdapt.exe(arr3);*/

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MergerBuSort.class);
        enhancer.setCallback(new HelloMethodInterceptor());
        MergerBuSort mergerBuSort = (MergerBuSort) enhancer.create();
        mergerBuSort.sort(args);
    }

    public static Comparable[] copy(Comparable[] arr) {
        Comparable[] a = new Comparable[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        return a;
    }

    //排序
    public abstract void sort(Comparable[] array);

    //比较
    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    //交换位置
    public void exch(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    protected boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (less(arr[i + 1], arr[i])) return false;
        }
        return true;
    }

    //打印
    public void show(Comparable[] array) {
        System.out.println("排序后:" + JSON.toJSONString(array));
        System.out.println("是否排序:" + isSorted(array));
    }

    public static List<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Random().nextInt());
        }
        return list;
    }

    public static Comparable[] getArray() {
        int size = 100000;
        Integer[] integers = new Integer[size];
        for (int i = 0; i < size; i++) {
            integers[i] = new Random().nextInt(size * 10);
            //integers[i] = i;
        }
        System.out.println("排序前:" + JSON.toJSONString(integers));

        return integers;
    }


    public Comparable[] subArray(Comparable[] array, int a, int b) {
        Comparable[] arr = new Integer[b - a + 1];
        int j = 0;
        for (int i = a; i <= b; i++) {
            arr[j++] = array[i];
        }
        return arr;
    }

    /**
     * 把两个有序子数组合并成一个大的有序数组
     *
     * @param array
     * @param lo
     * @param mid
     * @param hi
     */
    public void merger(Comparable[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (less(aux[j], aux[i])) array[k] = aux[j++];
            else array[k] = aux[i++];
        }
    }

}
