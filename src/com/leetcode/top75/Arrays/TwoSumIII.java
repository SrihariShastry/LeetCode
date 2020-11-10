package com.leetcode.top75.Arrays;

import java.util.ArrayList;
import java.util.HashMap;

class TwoSumIII {
    private final ArrayList<Integer> numbers;
    private final HashMap<Integer, Integer> map;
    int min;
    int max;

    /**
     * Initialize your data structure here.
     */
    public TwoSumIII() {
        numbers = new ArrayList<>();
        map = new HashMap<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        numbers.add(number);
        map.put(number, numbers.size() - 1);
        min = Math.min(min, number);
        max = Math.max(max, number);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        if (value > max * 2 || value < min * 2) return false;
        for (int num = 0; num < numbers.size(); num++) {
            int target = value - numbers.get(num);
            int idx = map.getOrDefault(target, -1);
            if (idx != num && idx >= 0) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */