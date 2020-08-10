package com.leetcode.top75.Arrays;

public class MaxProduct {

    class Solution {
        public int maxProduct(int[] nums) {
            int maxSF=nums[0];
            int minSF=nums[0];
            int res = maxSF;

            for(int i=1;i<nums.length;i++){
                int curr = nums[i];
                int tempMax = Math.max(curr,Math.max(maxSF*curr,minSF*curr));
                minSF = Math.min(curr,Math.min(maxSF*curr,minSF*curr));
                maxSF = tempMax;
                res = Math.max(maxSF,res);
            }
            return res;
        }
    }
}
