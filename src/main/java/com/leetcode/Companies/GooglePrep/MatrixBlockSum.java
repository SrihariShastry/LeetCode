package com.leetcode.Companies.GooglePrep;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] rangeSum = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rangeSum[i + 1][j + 1] = rangeSum[i + 1][j] + rangeSum[i][j + 1] - rangeSum[i][j] + mat[i][j];
            }
        }
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r1 = Math.max(0, i - K);
                int r2 = Math.min(n, i + K + 1);
                int c1 = Math.max(0, j - K);
                int c2 = Math.min(m, j + K + 1);
                ans[i][j] = rangeSum[r1][c1] + rangeSum[r2][c2] - rangeSum[r1][c2] - rangeSum[r2][c1];
            }
        }
        return ans;

    }
}
