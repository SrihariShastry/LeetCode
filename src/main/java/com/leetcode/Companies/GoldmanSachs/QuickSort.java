package com.leetcode.Companies.GoldmanSachs;

public class QuickSort {
    public int partition(int hi, int low, int[] arr) {
        int pivot = arr[low];
        int i = low;
        int j = hi;
        while (i < j) {
            while (arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;

            swap(i, j, arr);
        }
        swap(low, j, arr);
        return j;
    }

    public void swap(int lo, int hi, int[] arr) {
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }

    public void quickSort(int lo, int hi, int[] arr) {
        if (lo < hi) {
            int p = partition(hi, lo, arr);

            quickSort(lo, p, arr);
            quickSort(p + 1, hi, arr);
        }
    }
}
