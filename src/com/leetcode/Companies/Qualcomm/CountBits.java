package com.leetcode.Companies.Qualcomm;

public class CountBits {
    /**
     * Idea behind the solution is that when we "&" n and n-1,
     * the last significant bit/ the last set bit of the number flips.
     * this process continues until n becomes 0;
     *
     * @param n Number
     * @return the number of 1 bits in the number
     */

    public int hammingWeight(int n) {
        int bits = 0;
        while (n != 0) {
            bits++;
            n = n & (n - 1);
        }
        return bits;
    }
}
