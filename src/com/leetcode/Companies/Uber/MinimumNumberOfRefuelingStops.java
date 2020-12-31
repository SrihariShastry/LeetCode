package com.leetcode.Companies.Uber;

import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {

    /**
     * This algorithm is based on greedy method wherein we refuel at the gas station
     * which is reachable and which has max fuel among all the reachable stations
     * <p>
     * To keep track of the max station, we make use of priority queue and add the max value
     * to our fuel reservoir.
     * <p>
     * Time Complexity: O(NlogN) where N is the number of stations
     * Space Complexity: O(N) Space used by Priority Queue
     *
     * @param target    target distance
     * @param startFuel the fuel with which we start our journey
     * @param stations  Data about Gas Stations [0]-> distance from the starting point [1]-> Fuel
     * @return
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int i = 0;
        int res;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (res = 0; startFuel < target; res++) {
            while (i < stations.length && startFuel >= stations[i][0]) {
                pq.offer(stations[i++][1]);
            }
            if (pq.isEmpty()) return -1;
            startFuel += pq.poll();
        }

        return res;
    }
}
