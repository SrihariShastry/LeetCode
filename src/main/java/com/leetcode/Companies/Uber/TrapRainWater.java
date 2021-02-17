package com.leetcode.Companies.Uber;

public class TrapRainWater {
    /*
     * Time Complexity is O(N) where N is the number of height values inside the array
     * */
    public int trap(int[] height) {

        int i = 0, j = height.length - 1, maxWater = 0, current = 0, sum = 0;

        while (i < j) {
            maxWater = height[height[i] < height[j] ? i++ : j--];
            current = Math.max(current, maxWater);
            sum += current - maxWater;
        }
        return sum;
    }
}
