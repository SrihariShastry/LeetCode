package com.leetcode.Companies.GooglePrep;

public class FruitBasket {

    public int totalFruit(int[] tree) {
        int latest = -1;
        int secLatest = -1;
        int cur = 0;
        int latestCount = 0;
        int max = 0;

        for (int fruit : tree) {
            if (fruit == latest || fruit == secLatest) {
                cur++;
            } else {
                cur = latestCount + 1;
            }
            if (fruit == latest) {
                latestCount++;
            } else {
                latestCount = 1;
                secLatest = latest;
                latest = fruit;
            }
            max = Math.max(cur, max);
        }
        return max;
    }
}
