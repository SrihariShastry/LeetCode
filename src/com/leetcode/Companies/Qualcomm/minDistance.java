package com.leetcode.Companies.Qualcomm;

public class minDistance {
    /**
     * The idea behind the solution is based on Levenshtein Distance algorithm
     * which gives a way to calculate the minimum insertions, deletions or substitutions
     * to get the other string.
     * <p>
     * We try to change either String1 to String2 or vice versa.
     * We define a matrix which holds the 2 words along its two axis
     * <p>
     * if 2 chars are not same then we add 1 to the min value(left,dow, left_down) values.
     * if 2 chars are same then we add 1 to the min value(left,dow, left_down-1) values.
     * <p>
     * finally, the value at word1.length,word2.length of the matrix will give us the minimum
     * changes needed to change one word to another.
     *
     * @param s
     * @param t
     * @return
     */
    public int minDistance(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n * m == 0) return n + m;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i][j - 1];
                int down = dp[i - 1][j];
                int downLeft = dp[i - 1][j - 1];

                if (s.charAt(i - 1) != t.charAt(j - 1))
                    dp[i][j] = 1 + Math.min(Math.min(left, down), downLeft);
                else
                    dp[i][j] = 1 + Math.min(Math.min(left, down), downLeft - 1);
            }
        }
        return dp[n][m];
    }
}
