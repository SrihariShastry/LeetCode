package com.leetcode.Companies.GooglePrep;

import java.util.Random;

public class KthLargest {
    Random rand;

    public int quickSelect(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;

        int pivot = lo + rand.nextInt(hi - lo + 1);

        int temp = nums[hi];
        nums[hi] = nums[pivot];
        nums[pivot] = temp;
        pivot = hi;

        int i = lo;
        int j = lo - 1;

        while (i < pivot) {
            if (nums[i] <= nums[pivot]) {
                j++;
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            i++;
        }
        j++;

        temp = nums[j];
        nums[j] = nums[pivot];
        nums[pivot] = temp;

        return j;

    }

    public int findKthLargest(int[] nums, int k) {

        int lo = 0;
        int hi = nums.length - 1;
        rand = new Random();
        int pivot = quickSelect(nums, lo, hi);

        while (pivot != nums.length - k) {
            if (pivot < nums.length - k) {
                lo = pivot + 1;
            } else {
                hi = pivot - 1;
            }

            pivot = quickSelect(nums, lo, hi);
        }
        return nums[pivot];

    }
}
