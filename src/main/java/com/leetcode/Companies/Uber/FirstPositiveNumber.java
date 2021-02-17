package com.leetcode.Companies.Uber;

public class FirstPositiveNumber {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        //mark all nums which are out of bound
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = n + 1;
        }

        //check which numbers appear and mark those indices
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) continue;
            num--;
            if (nums[num] > 0)
                nums[num] = -1 * nums[num];
        }

        //check for the first positive number

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }

        return n + 1;

    }
}
