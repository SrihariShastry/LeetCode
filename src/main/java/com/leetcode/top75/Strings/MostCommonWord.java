package com.leetcode.top75.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWord {
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            HashMap<String, Integer> count = new HashMap<>();
            String[] p = paragraph.replaceAll("[^a-zA-Z0-9]"," ").toLowerCase().split(" ");
            Set<String> set = new HashSet<>(Arrays.asList(banned));
            int maxCount=0;
            String res="";

            for(String word:p){
                if(word.length()>0){
                    int c = count.getOrDefault(word,0);
                    count.put(word,c+1);
                }
            }
            for(String word:p){
                if(word.length()>0&&!set.contains(word)&&count.get(word)>=maxCount){
                    res=word;
                    maxCount=count.get(word);
                }
            }
            return res;



        }
    }
}
