package com.leetcode.Companies.GoldmanSachs;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubArrayWithSumAtLeastK {

    /**
     * We initially calculate the prefix sum in a separate array. Then we use deque in the following way:
     * - We offer indexes to the queue (to the last)
     * - If the difference between prefix sum for the index we inserted last and the current index is <= 0,
     * then we pop the index
     * - If the difference between prefix sum for the index we inserted last and the current index is >= k,
     * then we update the result to get the minimum length
     *
     * @param A Array with positive and negative numbers
     * @param K limit
     * @return the min length of the contiguous sub-array whose sum is at least K
     */
    public int shortestSubarray(int[] A, int K) {
        Deque<Integer> d = new ArrayDeque<>();
        int n = A.length;
        int[] B = new int[n + 1];
        B[0] = A[0];
        int res = n + 1;
        for (int i = 0; i < n; i++)
            B[i + 1] = B[i] + A[i];

        for (int i = 0; i <= n; i++) {
            while (!d.isEmpty() && B[i] - B[d.peek()] >= K)
                res = Math.min(res, i - d.poll());

            while (!d.isEmpty() && B[i] - B[d.peekLast()] <= 0)
                d.pollLast();

            d.offer(i);
        }

        return res == n + 1 ? -1 : res;
    }
}
