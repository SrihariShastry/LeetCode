package com.leetcode.Companies.Amazon;

public class CampusBikesII {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int[] dp = new int[1 << bikes.length];
        return dfs(workers, bikes, dp, 0, 0);
    }

    public int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    /**
     * count = worker's array pointer
     * used = bike's array pointer
     *
     * @param workers worker's positions
     * @param bikes   bikes' position
     * @param dp      storing intermediate results
     * @param mask    used to track assignments
     * @param worker  current worker
     * @return sum of minimum distances of this combination
     */
    public int dfs(int[][] workers, int[][] bikes, int[] dp, int mask, int worker) {
        if (worker == workers.length) return 0;

        if (dp[mask] != 0) return dp[mask];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            //checking if 2^ith bit is set
            //meaning, checking if ith bike has not been assigned in this combination

            //when we set the ith bit in mask, we are explicitly saying that
            // ith bike has been assigned to current worker;
            //then we go on to assign other bikes to the next worker

            if ((mask & (1 << i)) == 0) {
                //set the ith bit in the mask
                mask = mask | (1 << i);
                min = Math.min(min, dfs(workers, bikes, dp, mask, worker + 1)
                        + dist(workers[worker], bikes[i]));

                //backtracking
                //reset the ith bit by XOR.
                mask = mask ^ (1 << i);
            }
        }
        dp[mask] = min;
        return min;
    }
}
