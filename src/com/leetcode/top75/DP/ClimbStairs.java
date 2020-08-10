package com.leetcode.top75.DP;

public class ClimbStairs {
    class Solution {
        public int climbStairs(int n) {
            int[] memo = new int[n+1];
            return Climb(0,n,memo);
        }
        private int Climb(int i, int n, int[] memo){
            if(i == n)
                return 1;
            if(i>n)
                return 0;
            if(memo[i]>0)
                return memo[i];

            memo[i]= Climb(i+1,n,memo)+Climb(i+2,n,memo);
            return memo[i];
        }
    }
    //really good solution
    class Solution2 {
        public int climbStairs(int n) {
            int[] dp = new int[n+1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
    }
}
