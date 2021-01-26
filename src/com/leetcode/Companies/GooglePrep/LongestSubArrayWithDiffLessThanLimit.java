package com.leetcode.Companies.GooglePrep;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestSubArrayWithDiffLessThanLimit {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        int i = 0;
        int j;
        for (j = 0; j < nums.length; j++) {
            while (!max.isEmpty() && nums[j] > max.peekLast()) max.pollLast();
            while (!min.isEmpty() && nums[j] < min.peekLast()) min.pollLast();
            max.add(nums[j]);
            min.add(nums[j]);
            if (max.peekFirst() - min.peekFirst() > limit) {
                if (max.peekFirst() == nums[i]) max.pollFirst();
                if (min.peekFirst() == nums[i]) min.pollFirst();
                i++;
            }
        }
        return j - i;
    }
}
