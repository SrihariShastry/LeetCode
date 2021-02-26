package com.leetcode.Companies.GooglePrep;

import java.util.ArrayList;
import java.util.Arrays;

public class QueueReconstruction {
    /**
     * we sort the array:
     * * Decreasing Height;
     * * Increasing k Value;
     * <p>
     * we then place the people to kth indexes and return the output;
     * This problem wants to return an order of people according to k values
     *
     * @param people array of people where [i][0]->height of person i, [i][1] -> number of people who are in front of i
     *               whose height is greater than or equal to i's height
     * @return order of arrangement
     */
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        ArrayList<int[]> res = new ArrayList<>();

        for (int[] p : people) {
            res.add(p[1], p);
        }

        return res.toArray(new int[res.size()][2]);

    }
}
