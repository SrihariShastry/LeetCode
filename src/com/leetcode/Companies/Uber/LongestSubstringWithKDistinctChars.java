package com.leetcode.Companies.Uber;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctChars {

    /**
     * LinkedHashMap enables order among the entries in the HashMap.
     * Element Reentry into the LinkedHashMap has no effect on changing the position of the key.
     * <p>
     * We remove the element which was least encountered
     * we achieve this by getting the left most element in the LinkedHashMap
     * through map.entrySet().iterator().next()
     * <p>
     * For every character we update the position of the entry by removing and reinserting the entry
     * to the linkedHashMap.
     *
     * @param s String
     * @param k Max Number of Distinct Characters the SubString can have
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() * k == 0) return 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>(k + 1);
        int i = 0;
        int j = 0;
        int maxLen = 0;
        while (j < s.length()) {
            map.remove(s.charAt(j));
            map.put(s.charAt(j), j++);

            if (map.size() == k + 1) {
                Map.Entry<Character, Integer> leftMost = map.entrySet().iterator().next();
                map.remove(leftMost.getKey());
                i = leftMost.getValue() + 1;
            }
            maxLen = Math.max(maxLen, j - i);

        }
        return maxLen;
    }
}
