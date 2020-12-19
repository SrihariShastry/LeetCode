package com.leetcode.top75.DP;

public class CoinChangeII {

    public int coinChange(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int c = coin; c <= amount; c++) {
                dp[c] += dp[c - coin];
            }
        }
        return dp[amount];
    }
}
