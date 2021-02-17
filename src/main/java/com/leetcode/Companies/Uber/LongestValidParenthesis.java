package com.leetcode.Companies.Uber;

public class LongestValidParenthesis {
    /**
     * For this problem we need to traverse the string from left to right
     * and then from right to left
     * <p>
     * While we are travelling from left to right, we need to make sure that
     * the closing parenthesis count is not more than the open parenthesis
     * <p>
     * While we are travelling from right to left, we need to make sure that
     * the open parenthesis count should not exceed closing parenthesis
     *
     * @param s Input with parenthesis
     * @return
     */
    public int longestValidParentheses(String s) {
        int open = 0, close = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') open++;
            else if (c == ')') close++;
            if (open == close) res = Math.max(res, open * 2);
            if (close > open) open = close = 0;
        }
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '(') open++;
            else if (c == ')') close++;

            if (open == close) res = Math.max(res, open * 2);
            if (open > close) open = close = 0;
        }
        return res;
    }
}
