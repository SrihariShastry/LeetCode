package com.leetcode.Companies.Qualcomm;

public class moveZeros {

    public void moveZeros(int[] nums) {
        /**
         * We keep shifting the elements o the left until we run out of elements which are greater than 0
         * We then assign all remaining elements to 0;
         *
         */
        int i = 0;
        for (int num : nums) {
            if (num != 0)
                nums[i++] = num;
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
