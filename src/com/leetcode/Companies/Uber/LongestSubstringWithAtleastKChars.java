package com.leetcode.Companies.Uber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithAtleastKChars {
    /**
     * this approach makes use of two pointer approach.
     * These are the considerations we need to look into while solving this problem
     * with two pointer approach:
     * 1. We need to check the count of all chars within the window is greater than or equal to k
     * 2. We need to keep track of how many unique characters are there within the window
     * 3. We need to check the String for a substring with 1...n unique characters and
     * with each unique character count being >= k
     * 4. we expand the window when the unique characters within the window is <= the loop count
     * 5. we contract the window when the unique characters within the window is > than loop count
     * <p>
     * Note: we need to reset the count array for every loop just to get the true count of
     * each characters
     *
     * @param s String
     * @param k Minimum Character Frequency
     * @return Length of the longest Substring
     */
    public int longestSubstring(String s, int k) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray())
            set.add(c);
        int len = 0;
        int[] count = new int[26];
        int totUniqueChars = set.size();
        for (int curUnique = 0; curUnique <= totUniqueChars; curUnique++) {
            Arrays.fill(count, 0);
            int uniqueChars = 0, start = 0, end = 0, kUniqueChars = 0;
            while (end < s.length()) {
                if (uniqueChars <= curUnique) {
                    //expand window
                    int index = s.charAt(end) - 'a';
                    if (count[index] == 0) uniqueChars++;
                    count[index]++;
                    if (count[index] == k) kUniqueChars++;

                    end++;
                } else {
                    //contact window
                    int index = s.charAt(start) - 'a';
                    if (count[index] == k) kUniqueChars--;
                    count[index]--;
                    if (count[index] == 0) uniqueChars--;

                    start++;
                }
                if (uniqueChars == curUnique && uniqueChars == kUniqueChars) {
                    len = Math.max(len, end - start);
                }
            }
        }
        return len;
    }
}
