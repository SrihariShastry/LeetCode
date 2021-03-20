package com.leetcode.Companies.GoldmanSachs;

import java.util.Arrays;

public class KnightProbability {

    double[][][] dp;

    public double knightProbability(int N, int K, int r, int c) {
        dp = new double[N][N][K + 1];

        for (double[][] rows : dp)
            for (double[] row : rows)
                Arrays.fill(row, -1.0);

        return helper(N, K, r, c);
    }

    public double helper(int n, int k, int r, int c) {
        if (k == 0) return 1.0;
        if (dp[r][c][k] != -1.0) return dp[r][c][k];

        int[][] dirs = new int[][]{{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        double prob = 0.0;
        for (int[] dir : dirs) {
            int row = r + dir[0];
            int col = c + dir[1];

            if (isValid(row, col, n)) prob += (1.0 / 8) * helper(n, k - 1, row, col);
        }
        return dp[r][c][k] = prob;
    }

    public boolean isValid(int r, int c, int n) {
        return (r >= 0 && c >= 0 && r < n && c < n);
    }
}
