package com.jin.arithmetic.find;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于链表的map
 *
 * @author jinpeng
 * @date 2019/7/25.
 */
public class MyLinkedMap<K, V> {

    public Entry entry;
    public int size;

    public class Entry {
        public K key;
        public V value;
        public Entry next;

        public Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }
    }

    public void put(K key, V value) {
        Entry gEntry = getEntry(key);
        if (gEntry != null) {
            gEntry.value = value;
            return;
        }
        Entry oldEntry = this.entry;
        this.entry = new Entry(key, value, oldEntry);
        size++;
    }

    public V get(K key) {
        Entry gEntry = getEntry(key);
        if (gEntry == null) {
            return null;
        }
        return gEntry.value;
    }

    public Entry getEntry(K key) {
        if (this.entry == null) {
            return null;
        }
        for (Entry e = this.entry; e != null; e = e.next) {
            if (e.key.equals(key)) {
                return e;
            }
        }
        return null;
    }

    public void entrySet() {
        List<Entry> list = new ArrayList<>();
        while (entry.hasNext()) {

        }
    }


}
