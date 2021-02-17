package com.leetcode.top75.Matrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class NonOveralppingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        //Sort according to Start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> res = new LinkedList<>();
        int count = 0;
        //Edge Case
        if (intervals.length == 0) return 0;

        res.addLast(intervals[0]);
        int i = 1;
        // for every overlapping interval, increase count
        while (i < intervals.length) {
            if (!res.isEmpty() && intervals[i][0] < res.peekLast()[1]) {
                if (intervals[i][1] < res.peekLast()[1]) {
                    res.removeLast();
                    res.offerLast(intervals[i]);
                }
                count++;

            } else {
                res.offer(intervals[i]);
            }
            i++;
        }
        return count;
    }
}
