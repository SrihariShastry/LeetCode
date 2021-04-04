package com.leetcode.Companies.GoldmanSachs;

/**
 * Exactly like House robbery. We convert the problem to a house robbery and solve it exactly the same way
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        int[] preSum = new int[10001];
        int[] dp = new int[10001];

        for (int num : nums) {
            preSum[num] += num;
        }

        dp[0] = preSum[0];
        dp[1] = preSum[1];
        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(dp[i - 2] + preSum[i], dp[i - 1]);
        }

        return dp[10000];
    }
}
