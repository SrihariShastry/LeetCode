package com.leetcode.top75.Matrix;

import java.util.*;

public class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        // the number of edges in a tree = the number of nodes -1
        if (edges.length != n - 1) return false;

        //rest is the same as course Scheduling
        Set<Integer> seen = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] a : edges) {
            map.get(a[0]).add(a[1]);
            map.get(a[1]).add(a[0]);
        }

        q.offer(0);
        seen.add(0);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int a : map.get(node)) {
                if (seen.contains(a)) {
                    continue;
                }
                q.offer(a);
                seen.add(a);
            }
        }
        return seen.size() == n;
    }
}
