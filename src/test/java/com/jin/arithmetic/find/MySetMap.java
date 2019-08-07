package com.jin.arithmetic.find;

/**
 * 基于数组的顺序map
 *
 * @author jinpeng
 * @date 2019/7/25.
 */
public class MySetMap<K extends Comparable<K>, V> {

    private K[] keys;
    private V[] values;
    private int n;

    public MySetMap(int capacity) {
        this.keys = (K[]) new Comparable[capacity];
        this.values = (V[]) new Object[capacity];
    }

    public void put(K key, V value) {
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            //存在更新
            values[i] = value;
        } else {
            //不存在就插入 i位置前面的元素向前移动一位,新值插入i位置
            for (int j = n; j > i; j--) {
                keys[j] = keys[j - 1];
                values[j] = values[j - 1];
            }
            keys[i] = key;
            values[i] = value;
        }
    }

    public V get(K key) {
        if (isEmpty()) return null;
        int i = rank(key);
        //存在返回
        if (i < n && keys[i].compareTo(key) == 0) return values[i];
        else return null;
    }

    /**
     * 查找key的位置,如果不存就返回大于key的最小值位置
     *
     * @param key
     * @return
     */
    public int rank(K key) {
        int start = 0;
        int end = keys.length - 1;
        while (start <= end) {
            int index = start + (end - start) / 2;
            int cmp = keys[index].compareTo(key);
            if (cmp == 0) return index;
            else if (cmp < 0) end = index - 1;
            else if (cmp > 0) start = index + 1;
        }
        return start;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }


}
