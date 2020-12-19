package com.leetcode.top75.Matrix;

import java.util.*;

//LC:417
public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] atlantic = new boolean[n][m];
        boolean[][] pacific = new boolean[n][m];

        Queue<int[]> pQ = new LinkedList<>();
        Queue<int[]> aQ = new LinkedList<>();

        //vertical bar
        for (int i = 0; i < n; i++) {
            pQ.offer(new int[]{i, 0});
            aQ.offer(new int[]{i, m - 1});
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;

        }

        //horizontal bar
        for (int i = 0; i < m; i++) {
            pQ.offer(new int[]{0, i});
            aQ.offer(new int[]{n - 1, i});
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }

        bfs(matrix, pQ, pacific);
        bfs(matrix, aQ, atlantic);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }

            }
        }
        return res;

    }

    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {

        int n = matrix.length;
        int m = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]])
                    continue;

                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
