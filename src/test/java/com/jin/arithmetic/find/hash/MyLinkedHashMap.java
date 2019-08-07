package com.jin.arithmetic.find.hash;

import com.jin.arithmetic.find.MyLinkedMap;

/**
 * @author jinpeng
 * @date 2019/7/29.
 */
public class MyLinkedHashMap<K, V> {

    private MyLinkedMap<K,V>[] linkedMaps = new MyLinkedMap[100];

    public V get(K key) {
        int hashCode = key.hashCode();
        MyLinkedMap linkedMap = linkedMaps[hashCode];
        return (V) linkedMap.get(key);
    }

}
