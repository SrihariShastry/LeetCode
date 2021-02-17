package com.leetcode.top75.Arrays;

public class rotatedMin {
    class Solution {
        public int findMin(int[] nums) {
            for(int i=1;i<nums.length;i++){
                if(nums[i]<nums[i-1])
                    return nums[i];
            }
            return nums[0];
        }
    }
}
