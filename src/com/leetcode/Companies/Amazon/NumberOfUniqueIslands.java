package com.leetcode.Companies.Amazon;

import java.util.HashSet;
import java.util.Set;

public class NumberOfUniqueIslands {
    Set<String> distinctIslands;

    public int numDistinctIslands(int[][] grid) {
        distinctIslands = new HashSet<>();
        int numIslands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1)
                    distinctIslands.add(findIslands(grid, r, c, "X"));
            }
        }
        return distinctIslands.size();
    }

    public String findIslands(int[][] grid, int row, int col, String path) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return "O";

        grid[row][col] = 0;

        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        String[] move = new String[]{"U", "R", "D", "L"};

        String right = findIslands(grid, row + dirs[1][0], col + dirs[1][1], "R");
        String left = findIslands(grid, row + dirs[3][0], col + dirs[3][1], "L");
        String down = findIslands(grid, row + dirs[2][0], col + dirs[2][1], "D");
        String up = findIslands(grid, row + dirs[0][0], col + dirs[0][1], "U");

        return path + right + left + down + up;
    }
}
