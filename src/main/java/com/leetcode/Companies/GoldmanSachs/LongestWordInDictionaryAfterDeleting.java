package com.leetcode.Companies.GoldmanSachs;

import java.util.List;

public class LongestWordInDictionaryAfterDeleting {

    public String findLongestWord(String s, List<String> dictionary) {
        int[] sCount = new int[26];


        String longest = "";
        for (String word : dictionary) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < word.length() && word.charAt(i) == c) i++;
            }

            if (i == word.length() && word.length() >= longest.length()) {
                if (word.length() > longest.length() || word.compareTo(longest) < 0)
                    longest = word;
            }
        }
        return longest;
    }
}
