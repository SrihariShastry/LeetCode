package com.leetcode.Companies.GooglePrep;

public class CanBalance {
    /**
     * We initially calculate the total sum of all numbers in the array
     * then we keep recounting the sum and check if leftSum = sum - leftSum
     * if there is no sum like that, then we return false;
     *
     * @param nums input numbers
     * @return return if we can balance the array or nots
     */
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
