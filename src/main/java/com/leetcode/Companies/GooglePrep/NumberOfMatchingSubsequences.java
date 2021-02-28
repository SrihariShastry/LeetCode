package com.leetcode.Companies.GooglePrep;

import java.util.HashMap;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        HashMap<String, Integer> exists = new HashMap<>();
        int res = 0;
        for (String word : words) {
            if (exists.containsKey(word))
                res += exists.get(word);
            else {
                int i = 0, j = 0;
                while (i < S.length() && j < word.length()) {
                    if (S.charAt(i) == word.charAt(j)) j++;
                    i++;
                }
                if (j == word.length()) {
                    exists.put(word, 1);
                    res++;
                } else {
                    exists.put(word, 0);
                }
            }
        }
        return res;
    }
}
