package com.leetcode.GooglePrep;

public class CanBalance {
    public static boolean canBalance(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) sum += x;
        for (int num : nums) {
            if (leftsum == sum - leftsum) return true;
            leftsum += num;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canBalance(new int[]{10, -1, 1, 0, 10}));
    }


}
