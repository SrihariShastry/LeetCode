package com.leetcode.Companies.Uber;

public class GumpyBookStoreOwner {
    /**
     * This problem requires us to calculate the max customers which we can satisfy in that X window
     * applying sliding window pattern to get the max count of customers satisfied
     * <p>
     * rest is all just the flow.
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int i = 0;
        int alwaysCust = 0;
        int probableCust = 0;
        int maxGrumpyProfit = 0;
        while (i < n) {
            if (grumpy[i] == 0) {
                alwaysCust += customers[i];
            } else {
                probableCust += customers[i];
            }
            if (i >= X && grumpy[i - X] == 1) {
                probableCust -= customers[i - X];
            }
            maxGrumpyProfit = Math.max(maxGrumpyProfit, probableCust);
            i++;
        }
        return alwaysCust + maxGrumpyProfit;
    }
}
