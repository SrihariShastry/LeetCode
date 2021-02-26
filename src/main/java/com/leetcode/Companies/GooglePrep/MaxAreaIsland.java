package com.leetcode.Companies.GooglePrep;

/**
 * Basically the problem asks us to count the number of 1s in an island and return the max number of 1's found.
 */
public class MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;
        int res = 0;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] dir : dirs) {
            res += dfs(grid, i + dir[0], j + dir[1]);
        }

        return res + 1;
    }
}
