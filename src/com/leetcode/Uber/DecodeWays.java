package com.leetcode.Uber;

public class DecodeWays {

    public int decode(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];

            int temp = Integer.parseInt(s.substring(i - 2, i));
            if (temp >= 10 && temp <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];

    }
}
