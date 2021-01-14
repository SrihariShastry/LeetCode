package com.leetcode.Companies.Uber;

public class ConstructKPalindromeStrings {

    /**
     * We just have to count the number of odd character count in the String
     * If the odd count is greater than k then
     * its impossible to construct palindrome using all the characters
     * <p>
     * if k is greater than the string length, its again impossible to construct palindromes
     * <p>
     * The problem is all about dividing the String into k partitions and each partition should be a
     * palindrome. For us to form a palindrome, the basic rule is that we can have
     * only one odd character per partition. Hence, we say that the number of odd character count
     * can be less than or equal to k. Also, we cannot have the number of partitions to be greater than
     * String length.
     * <p>
     * This is why this solution works.
     *
     * @param s String
     * @param k number of palindromes to form
     * @return if we can form k Palindromes of String s.
     */
    public boolean canConstruct(String s, int k) {
        int[] hash = new int[26];
        int odd = 0;
        int n = s.length();
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            odd += hash[i] % 2 == 0? 1: 0;
        }
        return odd <= k && k <= n;

    }
}
