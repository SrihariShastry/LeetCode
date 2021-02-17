package com.leetcode.Companies.Amazon;

import java.util.Arrays;

public class MaxAreaOfCakeAfterCuts {

    /**
     * idea behind the solution is to calculate the maximum gap between cuts
     * we calculate this and then %1000000007 to keep it within the integer range
     * <p>
     * we initially sort the arrays to get the cuts in an order.
     *
     * @param h              number of rows
     * @param w              number of columns
     * @param horizontalCuts Array of Horizontal cuts
     * @param verticalCuts   Array of vertical cuts
     * @return Area of largest square after cuts
     */
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hl = horizontalCuts.length;
        int cl = verticalCuts.length;
        int maxH = Math.max(horizontalCuts[0], h - horizontalCuts[hl - 1]);
        int maxV = Math.max(verticalCuts[0], w - verticalCuts[cl - 1]);

        for (int i = 1; i < hl; i++)
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        for (int i = 1; i < cl; i++)
            maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i - 1]);

        return (int) ((long) maxV * maxH % 1000000007);

    }
}
