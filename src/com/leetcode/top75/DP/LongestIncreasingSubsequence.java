package com.leetcode.top75.DP;

public class LongestIncreasingSubsequence {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            if (nums.length == 0) return 0;
            dp[0] = nums[0];
            int i = 1;
            for (int num : nums) {
                if (dp[i - 1] < num) {
                    dp[i++] = num;
                } else {
                    //check if the number can replace a number in the current DP
                    int pos = BinarySearch(dp, 0, i - 1, num);
                    dp[pos] = num;
                }
            }
            return i;

        }
        private int BinarySearch(int[] dp, int low, int high,int target ) {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (dp[mid] == target) {
                    return mid;
                } else if (dp[mid] > target) {
                    high = mid - 1;
                } else if (dp[mid] < target) {
                    low = mid + 1;
                }

            }
            return low;
        }
    }
}
