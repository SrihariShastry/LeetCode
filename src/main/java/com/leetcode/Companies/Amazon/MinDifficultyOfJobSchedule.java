package com.leetcode.Companies.Amazon;

import java.util.Arrays;

public class MinDifficultyOfJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;

        int[][] memo = new int[n][d + 1];

        for (int[] m : memo)
            Arrays.fill(m, -1);
        return dfs(d, 0, jobDifficulty, memo);
    }

    /**
     * we try all types of job schedules by splitting the job difficulty array
     * into different sizes and taking the minimum for each day.
     *
     * @param d    day number
     * @param len  number of jobs scheduled for the day d
     * @param jobs the Job Difficulty array
     * @param memo to record the
     * @return
     */
    public int dfs(int d, int len, int[] jobs, int[][] memo) {
        int n = jobs.length;
        if (d == 0 && len == n) return 0;
        if (d == 0 || len == n) return Integer.MAX_VALUE;
        if (memo[len][d] != -1) return memo[len][d];
        int curMax = 0;
        int min = Integer.MAX_VALUE;
        for (int schedule = len; schedule < n; schedule++) {
            curMax = Math.max(curMax, jobs[schedule]);

            //get the schedule max for the rest of the days
            int temp = dfs(d - 1, schedule + 1, jobs, memo);

            if (temp != Integer.MAX_VALUE) {
                min = Math.min(min, temp + curMax);
            }
        }
        memo[len][d] = min;
        return memo[len][d];
    }
}
