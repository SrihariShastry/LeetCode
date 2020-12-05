package com.leetcode.Uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        char[] count;
        HashMap<String, List<String>> res = new HashMap<>();

        for (String word : strs) {
            String key = "";

            count = new char[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

//             for( int i=0;i<26;i++){
//                 key+=count[i];
//             }
            key = String.valueOf(count);
            if (res.containsKey(key)) {
                res.get(key).add(word);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(word);
                res.put(key, list);
            }

        }

        return new ArrayList(res.values());
    }
}
