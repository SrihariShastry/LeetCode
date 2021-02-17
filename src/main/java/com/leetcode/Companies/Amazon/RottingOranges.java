package com.leetcode.Companies.Amazon;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int timestamp = 2;

        while (rotOranges(grid, timestamp))
            timestamp++;

        for (int[] row : grid) {
            for (int item : row) {
                if (item == 1) return -1;
            }
        }
        return timestamp - 2;
    }

    public boolean rotOranges(int[][] grid, int timestamp) {
        boolean toContinue = false;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                //if current cell is the one that's going to rot,
                // then update the neighboring oranges to rot at the next timestamp
                if (grid[i][j] == timestamp) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        //check bounds and check if the neighbour is actually an orange
                        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
                            grid[x][y] = timestamp + 1;
                            //there are still oranges that has to rot.
                            toContinue = true;
                        }
                    }
                }
            }
        //return the decision if we need to rot more oranges or not
        return toContinue;
    }
}
