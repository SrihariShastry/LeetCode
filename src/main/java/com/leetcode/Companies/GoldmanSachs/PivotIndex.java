package com.leetcode.Companies.GoldmanSachs;

import java.util.Arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {

        int sum = Arrays.stream(nums).sum();

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }

        return -1;
    }
}
