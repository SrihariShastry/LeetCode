package com.leetcode.Companies.GooglePrep;

public class MaximizeDistance {
    public int maxDistToClosest(int[] seats) {

        int last = 0;
        int max = 0;

        for (int i = 1; i < seats.length; i++) {
            if (seats[i] == 1 || i == seats.length - 1) {
                int dist = i - last;
                if (seats[last] == 1 && seats[i] == 1) {
                    max = Math.max(max, (dist) / 2);
                } else {
                    max = Math.max(max, dist);
                }
                last = i;
            }
        }
        return max;

    }
}
