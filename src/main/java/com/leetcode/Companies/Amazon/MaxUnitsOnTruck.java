package com.leetcode.Companies.Amazon;

import java.util.Arrays;

public class MaxUnitsOnTruck {
    /**
     * Since this is a maximizing problem, we need to sort the array in descending order
     * based on number of units boxType[1]
     *
     * @param boxTypes  boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]
     * @param truckSize Max size of the truck
     * @return the maximum total number of units that can be put on the truck.
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int maxUnits = 0;
        //boxType[0] is the number of boxes
        //boxType[1] is the number of units per box
        for (int[] boxType : boxTypes) {
            int boxes = Math.min(boxType[0], truckSize);
            maxUnits += boxes * boxType[1];
            truckSize -= boxes;
        }
        return maxUnits;
    }
}
