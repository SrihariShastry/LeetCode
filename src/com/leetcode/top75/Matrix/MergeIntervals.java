package com.leetcode.top75.Matrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        int i = 1;
        //sort the intervals based on start time
//        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        /* Alternate way of sorting*/
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        //add the first interval to the List
        LinkedList<int[]> res = new LinkedList<>();
        res.addLast(intervals[0]);

        //check for overlapping and insert accordingly
        while (i < intervals.length) {
            if (intervals[i][0] <= res.getLast()[1]) {
                int[] temp = res.removeLast();
                temp[1] = Math.max(temp[1], intervals[i][1]);
                res.offer(temp);
            } else {
                res.offer(intervals[i]);
            }
            i++;
        }
        //convert LinkedList to int[][]
        return res.toArray(new int[res.size()][2]);
    }
}
