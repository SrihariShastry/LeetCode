package com.leetcode.Companies.GooglePrep;

public class FindValidMatrixFromRowSumAndColSum {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;

        int[][] res = new int[n][m];

        int i = 0;
        int j = 0;
        int a = 0;
        while (i < n && j < m) {
            a = res[i][j] = Math.min(rowSum[i], colSum[j]);
            if ((rowSum[i] -= a) == 0) i++;
            if ((colSum[j] -= a) == 0) j++;
        }

        return res;
    }
}
