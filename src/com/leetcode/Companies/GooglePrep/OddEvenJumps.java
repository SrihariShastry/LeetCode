package com.leetcode.Companies.GooglePrep;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {
    /**
     * Basic idea:
     * jump number is odd(1st/3rd/5th.. jump got you to this index) ?
     * look for the element which is just higher than current value
     * jump number is even(2nd/4th/6th.. jump got you to this index)?
     * look for the element which is just lower than the current value
     * <p>
     * We need two boolean arrays to store if we can reach the end
     * if we jump higher(odd) or lower(even) from the current index
     * <p>
     * if we reached the current index from an odd jump. lets say we reached the index on 1st jump
     * then the next jump is going to be 2nd jump which is even so we have to look for an element
     * that is just lower than the current value.
     * <p>
     * Similarly, If we reached the current index from an even jump. lets say we reached the index
     * on our 2nd jump, then the next jump is going to be our 3rd jump which makes it an odd jump.
     * So we have to look for an element that is just higher than the current value.
     * <p>
     * TreeSet basically helps us get the just higher and just lower indexes.
     * <p>
     * We traverse the array in reverse order and ultimately calculate the number of instances
     * where we have higher[i] = true; This is because, we want to know,
     * if on the first jump from the current index, we can reach the end
     * <p>
     * Note: We start with result being 1 because we already know that if we start from last index
     * then we have a good index because we are already at the last index.
     *
     * @param A Input Array
     * @return Number of good indexes.
     */
    public int oddEvenJumps(int[] A) {

        int n = A.length;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        int res = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(A[i]);
            Map.Entry<Integer, Integer> lo = map.floorEntry(A[i]);

            if (hi != null) higher[i] = lower[hi.getValue()];
            if (lo != null) lower[i] = higher[lo.getValue()];

            if (higher[i]) res++;

            map.put(A[i], i);
        }
        return res;
    }
}
