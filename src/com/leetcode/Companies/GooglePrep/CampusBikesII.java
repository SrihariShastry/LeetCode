package com.leetcode.Companies.GooglePrep;

public class CampusBikesII {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int[] dp = new int[1 << bikes.length];
        return dfs(workers, bikes, dp, 0, 0);
    }

    public int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public int dfs(int[][] workers, int[][] bikes, int[] dp, int used, int count) {
        if (count == workers.length) return 0;

        if (dp[used] != 0) return dp[used];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            //check if used
            if ((used & (1 << i)) == 0) {
                used = used | (1 << i);
                min = Math.min(min, dfs(workers, bikes, dp, used, count + 1)
                        + dist(workers[count], bikes[i]));
                //backtracking
                used = used ^ (1 << i);
            }
        }
        dp[used] = min;
        return min;
    }
}
