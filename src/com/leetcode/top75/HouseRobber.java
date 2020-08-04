package com.leetcode.top75;
//Given a list of non-negative integers representing the amount of money of each house,
// determine the maximum amount of money you can rob tonight without alerting the police.
public class HouseRobber {
    class Solution {
        public int rob(int[] nums) {

            // inception: f(k) = max(f(k – 2) + Ak, f(k – 1))
            int prevMax = 0;
            int currMax = 0;
            for (int x : nums) {
                int temp = currMax;
                currMax = Math.max(prevMax + x, currMax);
                prevMax = temp;
            }
            return currMax;
        }
    }
}
