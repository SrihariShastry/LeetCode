package com.leetcode.Companies.Uber;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumCostCities {
    public int n;
    public int[] parent;

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[x] = y;
            n--;
        }
    }

    public int find(int node) {
        int temp = node;

        while (parent[node] != node) {
            node = parent[node];
        }

        //Path compression.
        parent[temp] = node;
        return parent[node];
    }

    public int minimumCost(int N, int[][] connections) {
        /**
         * We need to implement Union Find along with kruskal's algorithm to find the least cost path
         * First, we sort the connections based on the cost of travelling
         * Since all edges are bidirectional, we need to have a graph that can hold this information
         *
         * The Time Complexity =
         */

        /**
         * Time complexity for sorting: O(E*log(E))
         */
        //Sorting according to the cost
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        parent = new int[N + 1];
        /**
         * Time complexity of the for loop below: O(N)
         */
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        int res = 0;
        n = N;
        /**
         * Time complexity of the loop below: E
         * Union and Find operations are considered to be O(1)
         */
        // join one edge at a time adding the cost to the result
        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];

            if (find(x) != find(y)) {
                res += connection[2];
                union(x, y);
            }

        }

        return n == 0 ? res : -1;

    }
}
