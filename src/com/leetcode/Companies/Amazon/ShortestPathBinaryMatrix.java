package com.leetcode.Companies.Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0 || grid[0][0] != 0) return -1;

        int[][] dirs =
                new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                assert cell != null;
                grid[cell[0]][cell[1]] = distance;
                if (cell[0] == grid.length - 1 && cell[1] == grid[0].length - 1)
                    return distance;

                for (int[] dir : dirs) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                            && grid[x][y] == 0) {
                        grid[x][y] = -1;
                        queue.add(new int[]{x, y});
                    }
                }
            }

            distance++;

        }
        return -1;
    }
}
