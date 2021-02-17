package com.leetcode.top75.DP;

public class LongestCommonSubsequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {

            if(text1.length()==0||text2.length()==0) return 0;

            int[][] lcs=new int[text1.length() + 1][text2.length() + 1];
            for (int i = 0; i <= text1.length(); i++) {
                for (int j = 0; j <= text2.length(); j++) {
                    if (i == 0 || j == 0)
                        lcs[i][j] = 0;
                    else if (text1.charAt(i - 1) == text2.charAt(j - 1))
                        lcs[i][j] = 1 + lcs[i - 1][j - 1];
                    else
                        lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
            return lcs[text1.length()][text2.length()];
        }
    }
}
