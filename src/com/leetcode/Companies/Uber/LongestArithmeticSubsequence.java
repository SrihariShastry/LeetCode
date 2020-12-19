package com.leetcode.Companies.Uber;

import java.util.HashMap;

public class LongestArithmeticSubsequence {
    /**
     * This problem utilizes a graph concept.
     * We have a hashmap where we store the count of numbers encountered with some distance d.
     * If d = A[i] - A[j], then for this distance we say that we have two numbers.
     * Hence, in the hashmap, initially, we store (d,2) -> which says for the distance d,
     * we have 2 numbers attached to it.
     * While looping the array, we continuously update the count for all distances.
     * <p>
     * Ultimately, we just get the max numbers associated with some distance d.
     *
     * @param nums List of Numbers
     * @return
     */
    public int longestArithSeqLength(int[] nums) {
        int res = 2, n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j];
                dp[i].put(d, dp[j].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[i].get(d));
            }
        }
        return res;
    }
}
