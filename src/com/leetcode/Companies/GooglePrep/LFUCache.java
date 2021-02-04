package com.leetcode.Companies.GooglePrep;

import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache {
    HashMap<Integer, Integer> counts;
    HashMap<Integer, Integer> vals;
    HashMap<Integer, LinkedHashSet<Integer>> cache;
    int min;
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        counts = new HashMap<>();
        vals = new HashMap<>();
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (!vals.containsKey(key)) return -1;

        int count = counts.get(key);
        counts.put(key, count + 1);
        cache.get(count).remove(key);
        if (count == min && cache.get(count).size() == 0)
            min++;

        cache.putIfAbsent(count + 1, new LinkedHashSet<>());
        cache.get(count + 1).add(key);

        return vals.get(key);
    }

    public void put(int key, int value) {

        if (this.capacity <= 0) return;

        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }

        if (vals.size() >= capacity) {
            //update Cache
            int remKey = cache.get(min).iterator().next();
            cache.get(min).remove(remKey);

            //update vals
            vals.remove(remKey);

            //update count
            counts.remove(remKey);
        }

        vals.put(key, value);
        counts.put(key, 1);
        cache.putIfAbsent(1, new LinkedHashSet<>());
        cache.get(1).add(key);
        min = 1;
    }
}