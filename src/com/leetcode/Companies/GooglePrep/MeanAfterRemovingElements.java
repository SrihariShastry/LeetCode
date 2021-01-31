package com.leetcode.Companies.GooglePrep;

import java.util.Arrays;

public class MeanAfterRemovingElements {

    public double trimMean(int[] arr) {
        int n = arr.length;
        double sum = 0;
        Arrays.sort(arr);
        for (int i = n / 20; i < n - n / 20; i++) {
            sum += arr[i];
        }

        return sum / (n - n / 10.0);

    }
}
