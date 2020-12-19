package com.leetcode.Companies.Uber;

public class SlidingWindowMaximum {
    /**
     * In This problem we are to find out the maximum number present in each window.
     * The window size is given as input.
     * The Naive approach is to repeatedly find out the max in each window and sliding the window by 1 position
     * This approach will take O(N^2) time.
     * <p>
     * We have a better solution for this problem. We scan the array from left to right and right to left
     * and we store the maximum found at each position in left[] array and right[] array respectively
     * we then check the max for each window and this is done by calculating the border for each window
     * From right, it's gonna be the left most element of the window
     * From left, it's going to be the right most element of the window.
     * the index we look for in the left array will be i + k -1 and for the right array it'll be i.
     *
     * @param nums Array of Numbers
     * @param k    Window Size
     * @return Array containing max at each Window
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int i = 1;
        int j;
        int[] res = new int[n - k + 1];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        while (i < nums.length) {
            left[i] = (i % k) == 0 ? nums[i] : Math.max(nums[i], left[i - 1]);
            j = n - i - 1;
            right[j] = ((j + 1) % k == 0) ? nums[j] : Math.max(right[j + 1], nums[j]);
            i++;
        }

        i = 0;
        while (i < (n - k + 1)) {
            res[i] = Math.max(right[i], left[i + k - 1]);
            i++;
        }
        return res;
    }
}
