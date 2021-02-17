package com.leetcode.Companies.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }

    public List<String> dfs(String s, List<String> dict, HashMap<String, List<String>> map) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        if (map.containsKey(s)) return map.get(s);
        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> temp = dfs(s.substring(word.length()), dict, map);
                for (String t : temp) {
                    res.add(word + (t.isEmpty() ? "" : " ") + t);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
