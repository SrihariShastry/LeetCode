package com.leetcode.Companies.Uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    /**
     * This solution takes the sliding window approach we keep incrementing the char count
     * at i and to slide the window, we negate the char count at i - window size(size of string p)
     * we then check if the two arrays ie., pCount and count are equal
     * if they are then add the index (i-window+1)
     * otherwise, continue the loop
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int window = p.length();
        int i = 0;
        char[] pCount = new char[26];

        if (s.length() == 0) return res;
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        char[] count = new char[26];
        while (i < s.length()) {

            count[s.charAt(i) - 'a']++;
            if (i >= window) {
                count[s.charAt(i - window) - 'a']--;
            }
            if (Arrays.equals(pCount, count))
                res.add(i - window + 1);
            i++;

        }
        return res;
    }
}
