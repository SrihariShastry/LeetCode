package com.leetcode.Companies.GooglePrep;

import java.util.Arrays;

public class KclosestPointsToOrigin {
    public int quickSelect(int[][] points, int l, int r) {
        if (l == r) return l;
        int[] pivot = points[l];
        int pivotInx = l;
        l++;
        while (l <= r) {
            if (distance(points[l], pivot) <= 0) l++;
            else if (distance(points[r], pivot) >= 0) r--;
            else {
                swap(points, l, r);
            }
        }
        swap(points, pivotInx, r);
        return r;
    }

    public int[][] kClosest(int[][] points, int K) {
        int lo = 0;
        int hi = points.length - 1;


        while (lo < hi) {
            int mid = quickSelect(points, lo, hi);
            if (mid == K) break;
            else if (mid < K)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return Arrays.copyOfRange(points, 0, K);
    }

    private void swap(int[][] points, int left, int right) {
        int[] temp = points[left];
        points[left] = points[right];
        points[right] = temp;
    }

    public int distance(int[] x, int[] y) {
        return x[0] * x[0] - y[0] * y[0] + x[1] * x[1] - y[1] * y[1];
    }
}
