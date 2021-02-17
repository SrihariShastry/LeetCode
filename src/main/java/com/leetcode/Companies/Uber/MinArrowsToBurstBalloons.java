package com.leetcode.Companies.Uber;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0 || points[0].length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(i -> i[0]));
        int arrows = 1;
        int last = points[0][1];

        for (int[] point : points) {
            if (point[0] > last) {
                arrows++;
                last = point[1];
            } else {
                last = Math.min(last, point[1]);
            }
        }
        return arrows;
    }
}
