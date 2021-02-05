package com.leetcode.Companies.Amazon;

public class NumberOfProvinces {
    /**
     * if City A is connected to city B, then call dfs fom city B and see which all are connected
     * from City B. Mark all of them as visited.
     *
     * @param isConnected Connectivity Matrix
     * @return number of providences that aren't connected.
     */
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < visited.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
}
