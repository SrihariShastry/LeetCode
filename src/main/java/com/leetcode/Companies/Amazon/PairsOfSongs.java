package com.leetcode.Companies.Amazon;

public class PairsOfSongs {
    /**
     * Idea: a%60 + b%60 = 60 OR (a%60 = 0 AND b%60 = 0)
     * Another way to represent the above equation is: a%60 = 60 - b%60;
     * this equation will not work when a%60 and b% 60 becomes 0;
     * to include this, we modify the equation to: a%60 = (60-b%60)%60;
     * This final equation combines the equation mentioned in the idea.
     */
    public int numPairsDivisibleBy60(int[] time) {
        int[] rem = new int[60];
        int count = 0;
        for (int t : time) {
            count += rem[(60 - t % 60) % 60];
            rem[t % 60]++;
        }
        return count;
    }
}
