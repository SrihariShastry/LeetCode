package com.leetcode.Companies.Uber;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] dependents = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] dep : prerequisites) {
            adj.get(dep[1]).add(dep[0]);
            dependents[dep[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (dependents[i] == 0)
                q.offer(i);
        }
        int[] res = new int[numCourses];
        int k = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            res[k++] = course;
            for (int c : adj.get(course)) {
                dependents[c]--;
                if (dependents[c] == 0) {
                    q.offer(c);
                }
            }
        }
        return k == numCourses ? res : new int[]{};

    }
}
