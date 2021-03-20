package com.leetcode.Companies.GoldmanSachs;

public class MinSizeSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int valSum = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            valSum += nums[i];

            while (valSum >= target) {
                result = Math.min(result, i + 1 - left);
                valSum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
