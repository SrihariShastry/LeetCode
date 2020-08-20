package com.leetcode.top75.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class topKFrequentWords {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {

            HashMap<String,Integer> wordCount = new HashMap<>();
            int maxCount=0;
            if(k==0)
                return new ArrayList<String>();

            for(String s:words){
                wordCount.put(s,wordCount.getOrDefault(s,0)+1);
            }
            List<String> wordList = new ArrayList<>(wordCount.keySet());
            Collections.sort(wordList,(w1, w2) -> wordCount.get(w1).equals(wordCount.get(w2))?
                    w1.compareTo(w2):wordCount.get(w2)-wordCount.get(w1));
            return wordList.subList(0,k);

        }
    }
}
