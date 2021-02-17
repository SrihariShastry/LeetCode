package com.leetcode.top75.Arrays;

public class maxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = nums[0];
            int curSum = nums[0];
            for(int i=1;i<nums.length;i++){
                //reject the current and start new or add the next element?
                curSum = Math.max(nums[i],curSum+nums[i]);
                //decide maxsum.
                maxSum = Math.max(maxSum,curSum);

            }
            return maxSum;
        }
    }
}
