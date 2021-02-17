package com.leetcode.Companies.Uber;

import java.util.Arrays;

/**
 * This program is based off of Longest increasing subSequence
 * First we sort the envelop sizes in ascending order based on width
 * If two envelopes have the same width, then we place the envelop with higher height first
 * <p>
 * Then, we form a 1-D array and we insert all the heights to the array
 * Since the width is already sorted , If we get the Longest Increasing SubSequence
 * of the heights array, we find the number of Russian Dolls with the given input.
 * <p>
 * One important note is that we make sure that the we also sort decreasing on the second dimension,
 * so two envelopes that are equal in the first dimension can never be in the same increasing subsequence
 */
public class RussianDollEnvelopes {

    public int LIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int i = 1;

        for (int num : nums) {
            if (dp[i - 1] < num) dp[i++] = num;
            else {
                int index = binarySearch(dp, 0, i, num);
                dp[index] = num;
            }
        }
        return i;
    }

    public int binarySearch(int[] arr, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            else if (target > arr[mid]) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] sec = new int[envelopes.length];
        int i = 0;
        for (int[] env : envelopes) {
            sec[i++] = env[1];
        }

        return LIS(sec);
    }
}
