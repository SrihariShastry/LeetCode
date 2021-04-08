package com.leetcode.Companies.GoldmanSachs;

public class ShortestDistance {
    public int shortestDistance(String[] wordsDict, String w1, String w2) {
        int dist = wordsDict.length;
        int word1 = -1;
        int word2 = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(w1)) {
                word1 = i;
            } else if (wordsDict[i].equals(w2)) {
                word2 = i;
            }
            if (word1 != -1 && word2 != -1) {
                dist = Math.min(dist, Math.abs(word1 - word2));
            }
        }
        return dist;
    }
}
