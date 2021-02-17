package com.leetcode.top75.Matrix;

import java.util.*;

public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //initialize adjacency Graph
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        // prepare Adjacency Graph
        for (int[] a : edges) {
            map.get(a[0]).add(a[1]);
            map.get(a[1]).add(a[0]);
        }

        int res = 0;
        boolean[] visited = new boolean[n];
        //Very similar to Number of Islands where we call dfs for the connected island
        for (int i = 0; i < n; i++) {
            res += dfs(map, i, visited);
        }

        return res;
    }

    public int dfs(HashMap<Integer, List<Integer>> map, int i, boolean[] visited) {
        //boundary Condition
        if (visited[i]) return 0;
        //set visited
        visited[i] = true;

        //attend to the neighbours
        for (int j : map.get(i)) {
            dfs(map, j, visited);
        }
        return 1;
    }
}
