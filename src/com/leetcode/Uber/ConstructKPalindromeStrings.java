package com.leetcode.Uber;

public class ConstructKPalindromeStrings {

    /**
     * We just have to count the number of odd character count in the String
     * If the odd count is greater than k then
     * its impossible to construct palindrome using all the characters
     * <p>
     * if k is greater than the string length, its again impossible to construct palindromes
     *
     * @param s
     * @param k
     * @return
     */
    public boolean canConstruct(String s, int k) {
        int[] hash = new int[26];
        int odd = 0;
        int n = s.length();
        for (char c : s.toCharArray()) {
            hash[c - 'a'] ^= 1;
        }

        for (int i = 0; i < 26; i++) {
            odd += hash[i] == 1 ? 1 : 0;
        }
        return odd <= k && k <= n;

    }
}
