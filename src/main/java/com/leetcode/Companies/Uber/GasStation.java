package com.leetcode.Companies.Uber;

public class GasStation {
    /**
     * THis solution is based on the idea that if we take k amount of fuel to travel
     * from station A to station B, if the cost to reaching that station is -ve, then
     * No station between A and B can reach B. So we try to do it from the next position from B + 1
     * <p>
     * While we try this, we keep the total cost of travel and at the end of the traversal,
     * if the total cost is less than 0, then we simply say that the travel cost is more than
     * the amount of fuel we are getting so there is no viable starting position. In that case,
     * we return -1;
     *
     * @param gas  Amount of gas we are going to get
     * @param cost Cost of reaching the next station
     * @return Starting point if Exists, where we can complete a round trip
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totCost = 0;
        int curCost = 0;
        int pos = 0;

        for (int i = 0; i < gas.length; i++) {
            totCost += gas[i] - cost[i];
            curCost += gas[i] - cost[i];

            if (curCost < 0) {
                pos = i + 1;
                curCost = 0;
            }
        }
        return totCost < 0 ? -1 : pos;
    }
}
