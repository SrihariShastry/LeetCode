package com.leetcode.Companies.GooglePrep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class LongestStringChain {
    /**
     * The problem asks us to get the max word chain length from the given word list.
     * We sort the word list by ascending order of the length of the words.
     * For each word, we try to remove one letter and get the max chain that we can get from that variation
     * <p>
     * One improvement in my view is to check if the variation is present in our word set to avoid
     * storing unnecessary words;
     * <p>
     * Time: O(NlogN + NL^2);
     * Space: O(N)
     *
     * @param words List of words
     * @return longest possible length of a word chain with words chosen from the given list of words.
     */
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));
        int max = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            int best = 0;

            for (int i = 0; i < word.length(); i++) {
                String temp = word.substring(0, i) + word.substring(i + 1);
                if (wordSet.contains(temp))
                    best = Math.max(best, map.getOrDefault(temp, 0) + 1);
            }

            map.put(word, best);
            max = Math.max(max, best);
        }

        return max;

    }
}
