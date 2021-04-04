package com.leetcode.Companies.GoldmanSachs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWord {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || set.contains(w.substring(0, w.length() - 1))) {
                res = res.length() < w.length() ? w : res;
                set.add(w);
            }
        }
        return res;
    }
}
