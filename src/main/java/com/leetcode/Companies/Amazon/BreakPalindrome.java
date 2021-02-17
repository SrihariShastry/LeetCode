package com.leetcode.Companies.Amazon;

public class BreakPalindrome {
    /**
     * @param palindrome Palindrome String
     * @return Converted Non Palindrome string
     */
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() < 2) return "";

        char[] p = palindrome.toCharArray();
        int n = p.length;
        for (int c = 0; c < n / 2; c++)
            if (p[c] != 'a') {
                p[c] = 'a';
                return String.valueOf(p);
            }
        p[n - 1] = 'b';
        return String.valueOf(p);
    }
}
