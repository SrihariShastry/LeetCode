package com.leetcode.Companies.Uber;

import java.util.Arrays;

public class IntersectionSizeTwo {

    /**
     * this problem requires us to first sort the intervals based on start value
     * max1 and max2 are the maximum and second maximum values
     * we parse the intervals one by one and update max1 and max2 accordingly
     * <p>
     * if the start integer of the interval is greater than the max integer collected so far
     * then we have to add 2 integers to the set and hence we increment the count by 2
     * and update the max1 and max2 values
     * <p>
     * if the start integer is only greater than max2, then we have an overlapping interval
     * that needs to add only one element to the set.
     * Hence we increment the count by 1 and we update max1 and max2
     * max2=max1==end?end-1:max1;
     * max1=end;
     *
     * @param intervals List of intervals
     * @return Minimum size of the set
     */
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
        int max1 = -1;
        int max2 = -1;
        int count = 0;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > max1) {
                count += 2;
                max1 = end;
                max2 = end - 1;
            } else if (start > max2) {
                count++;
                max2 = max1 == end ? max1 - 1 : max1;
                max1 = end;
            }
        }
        return count;
    }
}
