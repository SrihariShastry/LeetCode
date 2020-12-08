package com.leetcode.Uber;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
 * This problem requires a DP method
 * We first get all the co-ordinates which can be reached from(0,0)
 * We then try changing the direction for each of those co-ordinates
 * we use a DP[][] to store the cost to reach each of those nodes
 * we recursively call dfs on each of those changed directions
 * and update the cost to reach all the nodes
 * We then just return the cost to reach (N-1,N-1)
 * <p>
 * It is worth noting that the dp[][] will automatically store the least cost required
 * to reach a particular place since we update the dp[][]  as soon as we reach it
 * By extension, we store the minimum value required to get to that point at first go
 * DP[][] also acts as a grid which keeps track of visited places.
 */
public class MinimumCostToMakeValidPath {
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        Queue<int[]> bfs = new LinkedList<>();
        int cost = 0;

        for (int[] level : dp) {
            Arrays.fill(level, Integer.MIN_VALUE);
        }
        // First get the initial co-ordinates which can be reached from (0,0)
        dfs(grid, 0, 0, dp, cost, bfs);

        //recursively reach other un-reachable nodes by changing direction.
        while (!bfs.isEmpty()) {
            cost++;
            for (int size = bfs.size() - 1; size >= 0; size--) {
                int[] top = bfs.poll();

                for (int i = 0; i < 4; i++) {
                    dfs(grid, top[0] + dir[i][0], top[1] + dir[i][1], dp, cost, bfs);
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public void dfs(int[][] grid, int r, int c, int[][] dp, int cost, Queue<int[]> bfs) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || dp[r][c] != Integer.MIN_VALUE) return;

        dp[r][c] = cost;
        bfs.offer(new int[]{r, c});

        int nextDir = grid[r][c] - 1;
        dfs(grid, r + dir[nextDir][0], c + dir[nextDir][1], dp, cost, bfs);
    }
}
