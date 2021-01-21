package com.leetcode.Companies.GooglePrep;

public class CanJump {
    /**
     * The idea is to start from the end/ work backwards from the last index
     * Keep track of the smallest index that can "jump" to the last index.
     * Check whether the current index can jump to this smallest index.
     *
     * @param nums imput array
     * @return return if we can reach the last index starting from the first index
     */
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--)
            if (nums[i] + i >= last)
                last = i;

        return last <= 0;
    }

}
