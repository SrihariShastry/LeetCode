package com.leetcode.Companies.GooglePrep;

public class TimeNeededToInform {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, manager, informTime));
        }
        return res;
    }

    public int dfs(int cur, int[] manager, int[] informTime) {
        if (manager[cur] != -1) {
            informTime[cur] += dfs(manager[cur], manager, informTime);
            manager[cur] = -1;
        }
        return informTime[cur];
    }
}
