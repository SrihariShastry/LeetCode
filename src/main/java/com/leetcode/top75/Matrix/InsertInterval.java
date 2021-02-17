package com.leetcode.top75.Matrix;

import java.util.LinkedList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> res = new LinkedList<>();

        int i = 0;
        //add all intervals that come before the new interval
        while (i < intervals.length && intervals[i][0] < newInterval[0]) {
            res.offer(intervals[i]);
            i++;
        }

        //add the new interval after checking for collision
        if (i == 0 || res.getLast()[1] < newInterval[0]) {
            res.add(newInterval);
        } else {
            int[] temp = res.removeLast();
            temp[1] = Math.max(temp[1], newInterval[1]);
            res.offer(temp);
        }

        //add or merger the rest after comparing it to the latest interval.
        while (i < intervals.length) {
            int[] temp = res.getLast();

            if (intervals[i][0] <= temp[1]) {
                res.removeLast();
                temp[1] = Math.max(temp[1], intervals[i][1]);
                res.offer(temp);
            } else {
                res.offer(intervals[i]);
            }
            i++;
        }

        //return the result as an array
        return res.toArray(new int[res.size()][2]);
    }
}
