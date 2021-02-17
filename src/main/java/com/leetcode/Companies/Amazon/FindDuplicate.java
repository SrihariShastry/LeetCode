package com.leetcode.Companies.Amazon;

public class FindDuplicate {

    /**
     * This algorithm reduces the problem to Floyd's cycle detection algorithm
     * we have a fast pointer and a slow pointer.
     *
     * @param nums list of numbers with a duplicate
     * @return the duplicate
     */
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];

        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
