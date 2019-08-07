package com.jin.arithmetic.sort;

import com.alibaba.fastjson.JSON;

/**
 * 二叉堆排序
 * 优先队列
 *
 * @author jinpeng
 * @date 2019/8/1.
 */
public class BinaryHeapSort extends SortService {

    public static void main(String[] args) {
        BinaryHeapSort sort = new BinaryHeapSort(getArray());
        sort.printArr();
        int n = sort.size();
        for (int i = 0; i < n; i++) {
            //循环去除最大值,就相当于排序了
            System.out.print(sort.delMax() + " ");
        }
    }

    private Integer[] array;
    private int N;

    public BinaryHeapSort(int max) {
        array = new Integer[max];
    }

    public BinaryHeapSort(Comparable[] arr) {
        array = new Integer[arr.length + 1];
        array[0] = null;
        for (int i = 0; i < arr.length; i++) {
            insert((Integer) arr[i]);
        }
    }

    public void insert(Integer value) {
        array[N + 1] = value;
        swim(N + 1);
        N++;
    }

    public Integer max() {
        return array[1];
    }

    public Integer delMax() {
        int max = array[1];
        exch(array, 1, N--);
        array[N + 1] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return true;
    }

    int size() {
        return N;
    }

    public void printArr() {
        System.out.println("size=" + size());
        System.out.println(JSON.toJSONString(array));
        isSuccess();
        System.out.println();
    }

    /**
     * 上浮
     *
     * @param k
     */
    public void swim(int k) {
        while (k > 1 && less(array[k / 2], array[k])) {
            exch(array, k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下层
     *
     * @param key
     */
    public void sink(int key) {
        while (2 * key <= N) {
            int j = 2 * key;
            if (j < N && less(array[j], array[j + 1])) j++;
            if (!less(array[key], array[j])) break;
            exch(array, key, j);
            key = j;
        }
    }

    public void isSuccess() {
        for (int i = array.length - 1; i > 1; i--) {
            if (array[i] == null) break;
            if (less(array[i / 2], array[i])) {
                System.out.println(false);
                break;
            }
        }
        System.out.println(true);
    }

    @Override
    public void sort(Comparable[] array) {

    }
}
