package com.leetcode.Companies.GoldmanSachs;

import java.util.HashMap;
import java.util.Map;

public class KDifferentPairs {
    /**
     * @param nums array of elements
     * @param k    Difference allowed between each pair of numbers
     * @return the number of "Unique" pairs we can form where (nums[i] - nums[j]) = k
     * <p>
     * It's important to note that the pairs themselves have to be unique
     */
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if ((k == 0 && entry.getValue() > 1) || (k > 0 && map.containsKey(entry.getKey() - k))) {
                count++;
            }
        }
        return count;
    }
}
