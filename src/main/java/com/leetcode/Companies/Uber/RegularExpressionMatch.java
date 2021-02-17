package com.leetcode.Companies.Uber;

public class RegularExpressionMatch {
    /**
     * This is a Dynamic Programming Solution.
     * We PreProcess the Pattern and Check for * then set it to True if the String without 'c*'
     * Matches the pattern
     * Then, We have two cases
     * 1. if the text.charAt(i-1) == Pattern.charAt(j-1) || Pattern.charAt(j-1) == '.'
     * Simply take the diagonal Value
     * 2. if Pattern.charAt(j-1) == '*'
     * a. check if the String is still valid without the * characters [if(T[i][j-2]]
     * Simply take the T[i][j-2] Value
     * b. check if the Text.charAt[i-1] == Pattern's * character(Either '.' or some Character)
     * Simply Take the value above the current cell ( T[i-1][j] )
     * 3. If nothing works, then simply assign the cell to false.
     *
     * @param s Text String
     * @param p Pattern
     * @return Return if Text Matches Pattern
     */
    public boolean isMatch(String s, String p) {
        if (s.isEmpty() ^ p.isEmpty()) return false;
        int n = s.length(), m = p.length();
        boolean[][] T = new boolean[n + 1][m + 1];

        T[0][0] = true;

        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (p.charAt(i - 1) == '*') {
                T[0][i] = T[0][i - 2];
            }
        }
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    T[i][j] = T[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') {
                    if (T[i][j - 2])
                        T[i][j] = T[i][j - 2];
                    else if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        T[i][j] = T[i - 1][j];
                    }
                } else
                    T[i][j] = false;
            }
        }
        return T[n][m];
    }
}
