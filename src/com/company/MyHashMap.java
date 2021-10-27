package com.company;

public class MyHashMap<K, V> {

    private static final int SIZE = 16;

    private int size;

    private Entry<K, V>[] table = new Entry[SIZE];

    class Entry<K, V> {
        private final K key;
        private V value;
        private Entry next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private int getBucket(K key) {
        return key.hashCode() % SIZE;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int bucket = getBucket(key);
        Entry<K, V> entry = table[bucket];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Cannot add null key");
        }

        int bucket = getBucket(key);
        Entry<K, V> entry = table[bucket];
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (entry == null) {
            table[bucket] = newEntry;
            size++;
        } else {
            while (!entry.getKey().equals(key)) {
                if (entry.next == null) {
                    entry.next = newEntry;
                    size++;
                    return;
                }
                entry = entry.next;
            }
            entry.value = value;
        }
    }

    public boolean remove(K key) {
        if (key == null) {
            return false;
        }

        int bucket = getBucket(key);
        Entry<K, V> entry = table[bucket];
        if (entry == null) {
            return false;
        }

        while (!entry.getKey().equals(key)) {
            if (entry.next == null) {
                return false;
            }
            entry = entry.next;
        }

        table[bucket] = entry.next;
        size--;
        return true;
    }

    public void clear() {
        size = 0;
        table = new Entry[SIZE];
    }
}