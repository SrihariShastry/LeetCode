package com.leetcode.Companies.GooglePrep;

public class MaxPointsFromCards {
    /**
     * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
     * In one step, you can take one card from the beginning or from the end of the row.
     * You have to take exactly k cards.
     * <p>
     * we first get the first K element's sum and then add one element from the end and remove the k-ith element
     * from the start and recalculate the max
     *
     * @param cardPoints array of points
     * @param k          Max number of cards to pick
     * @return Max points we can get
     */
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0, rSum = 0, n = cardPoints.length, i, max;

        //add the first K elements
        for (i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }
        //consider one element from the right at a time and re-evaluate max
        for (max = lSum, i = 0; i < k; i++) {
            lSum -= cardPoints[k - 1 - i];
            rSum += cardPoints[n - 1 - i];

            max = Math.max(max, lSum + rSum);
        }
        return max;
    }
}
