package com.leetcode.Companies.Amazon;

import java.util.*;

public class CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        // 2001 because that's the max distance constraint that can be present in the problem
        List<int[]>[] distance = new List[2001];

        //for distance from 0 to 2000, we record all i and j respectively. Similar to bucket sort
        for (int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < bikes.length; j++) {
                int d = dist(worker, bikes[j]);
                if (distance[d] == null) {
                    distance[d] = new ArrayList<>();
                }

                distance[d].add(new int[]{i, j});
            }
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        HashSet<Integer> visited = new HashSet<>();
        //we can go from distance 0 to the end of distance and greedily assign bikes to workers
        // since the current bike is always going to be the minimum distance,
        // we can keep assigning the current bike to current worker.
        for (int i = 0; i < distance.length && visited.size() < n; i++) {
            if (distance[i] != null) {
                for (int[] pair : distance[i]) {
                    //if the current worker has not been assigned a bike
                    //and if the current bike has not been assigned to anyone else
                    //then assign the bike to worker
                    if (res[pair[0]] == -1 && !visited.contains(pair[1])) {
                        res[pair[0]] = pair[1];
                        visited.add(pair[1]);
                    }
                    //if all workers are assigned, then stop
                    if (visited.size() >= n) break;
                }
            }
        }
        return res;
    }

    public int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
