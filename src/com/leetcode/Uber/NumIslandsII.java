package com.leetcode.Uber;

import java.util.ArrayList;
import java.util.List;

public class NumIslandsII {

    /*Time Complexity:
     *
     *O(M*N+L)
     *
     * */
    int[][] grid;
    int[] parent;
    int[] rank;

    /**
     * this is a union find problem
     *
     * @param m         Number of rows
     * @param n         Number of Columns
     * @param positions Events
     * @return List containing Number of Islands after every event
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        grid = new int[m][n];           // to keep track of updates
        parent = new int[m * n];          // to keep track of who is whose parent
        rank = new int[m * n];            // to keep track of number of children each node has
        int count = 0;                   // number of islands
        List<Integer> res = new ArrayList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = i * n + j;
                parent[tmp] = tmp;
                rank[tmp] = 1;
            }
        }
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            if (grid[x][y] == 1) {
                res.add(count);
                continue;
            }
            grid[x][y] = 1;

            //row*n+columns gives the cell number in the grid

            int index = x * n + y;
            count++;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                // if the neighbour index is within bounds and if its marked as 1 in grid
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                    int nextIdx = nextX * n + nextY;
                    //if their parents are not the same
                    if (find(nextIdx) != find(index)) {
                        //merge the two and make them belong to same parent
                        union(index, nextIdx);
                        //since we merged, we need to decrease the number of islands
                        count--;
                    }
                }
            }
            //add the count to result;
            res.add(count);
        }
        return res;
    }

    public int find(int idx) {
        while (parent[idx] != idx) {
            idx = parent[idx];
        }
        return idx;
    }

    public void union(int idx, int nextIdx) {
        int rootX = find(idx);
        int rootY = find(nextIdx);


        //if children of X are less than Y then make Y the parent
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        }
        //if Children of Y are less than X then make X the parent
        else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        }
        //if their child count is same, then make Y the parent by increasing the count of Y
        else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }
    }
}
