package com.leetcode.Companies.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76583/11ms-JAVA-solution-using-merge-sort-with-explanation
 */
public class NumbersSmallerThanSelf {
    int[] count;

    public List<Integer> countSmaller(int[] nums) {

        int[] indexes = new int[nums.length];
        count = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, 0, nums.length - 1, indexes);
        ArrayList<Integer> res = new ArrayList<>();
        for (int j : count) {
            res.add(j);
        }
        return res;
    }

    public void mergeSort(int[] nums, int start, int end, int[] indexes) {
        if (end <= start) return;
        int mid = (start + end) / 2;

        mergeSort(nums, start, mid, indexes);
        mergeSort(nums, mid + 1, end, indexes);
        merge(nums, indexes, start, end);

    }

    public void merge(int[] nums, int[] indexes, int start, int end) {

        int mid = (start + end) / 2;
        int[] res = new int[end - start + 1];
        int resIndex = 0;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int rightCount = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[indexes[rightIndex]] < nums[indexes[leftIndex]]) {
                res[resIndex] = indexes[rightIndex];
                rightIndex++;
                rightCount++;
            } else {
                count[indexes[leftIndex]] += rightCount;
                res[resIndex] = indexes[leftIndex];
                leftIndex++;
            }
            resIndex++;
        }
        while (leftIndex <= mid) {
            res[resIndex] = indexes[leftIndex];
            count[indexes[leftIndex]] += rightCount;
            resIndex++;
            leftIndex++;
        }
        while (rightIndex <= end) {
            res[resIndex++] = indexes[rightIndex++];
        }
        for (int i = start; i <= end; i++) {
            indexes[i] = res[i - start];
        }
    }
}
