package com.leetcode.Uber;

import java.util.Arrays;

public class CherryPick {
    int[][][] dp;

    /**
     * This problem can also be seen as two walkers picking cherries from (0,0) to (N-1,N-1).
     * Since the manhattan distance between the two walkers is going to be the same from (0,0) or (N-1,N-1)
     * We can safely calculate the co-ordinates of the second walker if we have r1,c1,c2;
     * Hence, we initialize a 3D array to store the Cherries picked by two walkers
     *
     * @param grid Grid with information regarding the Cherries
     * @return the maximum number of cherries picked by the two walkers.
     */
    public int pickCherry(int[][] grid) {
        int n = grid.length;
        dp = new int[n][n][n];

        for (int[][] level : dp) {
            for (int[] row : level) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        return Math.max(0, helper(0, 0, 0, grid));
    }

    /**
     * This function calculates r2 using the formula r2=r1+c1-c2;
     * We check if the coordinates are out of bounds or if the grid has thorns in the co-ordinates
     * if one of the walkers have reached the end, it means that the other has reached as well and
     * that is why we check only for one of the walker's coordinates
     * if we are at the end, we just return the value stored at the N-1,N-1 coordinate
     * <p>
     * we also check to make sure to not let the two walkers share the same path
     * We do this by only checking if their row values or col values are same.
     * Its only required to check one of their values because
     * manhattan distance between the two people is the same and
     * if their rows are same then their columns will also be the same
     * <p>
     * we basically move in two directions (down , right)
     * the combinations of movements are as follows:
     * walker1: down; walker2 : down
     * walker1:right; walker2:down
     * walker1: down; walker2 right
     * walker1: right; walker2: right
     * <p>
     * these combinations have to be traversed and we need to
     * choose the max cherries picked from these 4 paths
     * we then add the values of walker1 and walker2's current cell values and store it in dp[r1][c1][c2]
     * we return the same value back to the calling function.
     *
     * @param r1   Row number of first Walker
     * @param c1   Column number of First Walker
     * @param c2   Column numer of Second Walker
     * @param grid Grid with information regarding the Cherries
     * @return the max number of cherries picked from (0,0) to (N-1,N-1) to (0,0)
     */
    public int helper(int r1, int c1, int c2, int[][] grid) {
        int r2 = r1 + c1 - c2;
        int n = grid.length;
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        if (r1 == n - 1 && c1 == n - 1) return grid[r1][c1];
        if (dp[r1][c1][c2] != Integer.MIN_VALUE) return dp[r1][c1][c2];

        int ans = grid[r1][r2];
        if (c1 != c2) ans += grid[r2][c2];

        int temp = Math.max(helper(r1, c1 + 1, c2 + 1, grid), helper(r1, c1 + 1, c2, grid));
        temp = Math.max(temp, helper(r1 + 1, c1, c2 + 1, grid));
        temp = Math.max(temp, helper(r1 + 1, c1, c2, grid));

        dp[r1][c1][c2] = temp + ans;
        return dp[r1][c1][c2];
    }
}
