package com.leetcode.Companies.GooglePrep;

public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                len = Math.max(len, dfs(matrix, i, j, dp));
            }
        }
        return len;

    }

    public int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
            }
        }


        return ++cache[i][j];
    }
}
