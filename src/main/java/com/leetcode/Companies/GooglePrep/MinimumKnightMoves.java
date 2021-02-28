package com.leetcode.Companies.GooglePrep;

import java.util.HashMap;

public class MinimumKnightMoves {
    public int minKnightMoves(int x, int y) {
        HashMap<String, Integer> visited = new HashMap<>();
        visited.put(0 + "," + 0, 0);

        return helper(x, y, visited);
    }

    /**
     * We perform a backward search i.e., from the target to (0,0).
     *
     * @param x  current x co-ordinate
     * @param y  current y co-ordinate
     * @param dp memoized values
     * @return
     */
    public int helper(int x, int y, HashMap<String, Integer> dp) {
        x = Math.abs(x);
        y = Math.abs(y);
        String key = x + "," + y;
        if (dp.containsKey(key))
            return dp.get(key);

        //to handle special edge cases :(0,2),(2,0),(1,1)
        if (x + y == 0) return 0;
        if (x + y == 2) return 2;

        //we either move 1 position x and 2 positions y or 2 positions x and 1 position y.
        //Since we are sticking to the first quadrant due to symmetry, its easier to do this way
        int val = Math.min(helper(x - 1, y - 2, dp), helper(x - 2, y - 1, dp)) + 1;

        dp.put(key, val);
        return val;
    }
}
