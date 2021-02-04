package com.leetcode.Companies.GooglePrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    /**
     * The Key we form, is always an offset to 'a' so we always get the same key for all words that
     * belong to the same group
     * <p>
     * for every word, we calculate the key(ie., offset to 'a') and we add the word to the key
     * Edge cases such as the char offset going < a is handled by adding 26 to the sum
     * <p>
     * we add the character to the key.
     * <p>
     * Running time complexity: O(N*M)(n = number of words and M is the length of the longest word)
     *
     * @param strings list of words
     * @return groups of words
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strings) {
            StringBuilder key = new StringBuilder();
            int offset = word.charAt(0) - 'a';
            for (int i = 0; i < word.length(); i++) {
                char c = (char) (word.charAt(i) - offset);

                //edge case
                if (c < 'a') c += 26;

                //add the character to the key
                key.append(c);
            }
            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
