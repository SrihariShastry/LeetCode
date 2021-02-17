package com.leetcode.top75.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            HashMap<String, ArrayList<String>> anagrams= new HashMap<>();

            if(strs.length==0)return res;

            for(String s:strs){
                // HashSet<String> letterSet = new HashSet<>(Arrays.asList(s.split("")));
                char[] a=s.toCharArray();
                Arrays.sort(a);
                String key = String.valueOf(a);

                ArrayList<String> word = anagrams.getOrDefault(key,new ArrayList<String>());
                word.add(s);
                anagrams.put(key,word);
            }
            for(ArrayList<String> str: anagrams.values()){
                res.add(0,str);
            }
            return res;
        }
    }
}
