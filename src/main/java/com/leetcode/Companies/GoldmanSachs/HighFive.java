package com.leetcode.Companies.GoldmanSachs;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HighFive {
    public int[][] highFive(int[][] items) {

        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int[] item : items) {
            map.putIfAbsent(item[0], new PriorityQueue<>(5));
            map.get(item[0]).offer(item[1]);
            if (map.get(item[0]).size() > 5)
                map.get(item[0]).poll();
        }

        int[][] res = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> e : map.entrySet()) {

            int sum = 0;
            while (!e.getValue().isEmpty()) {
                sum += e.getValue().poll();
            }
            sum /= 5;
            res[i][0] = e.getKey();
            res[i][1] = sum;
            i++;
        }

        return res;
    }
}
