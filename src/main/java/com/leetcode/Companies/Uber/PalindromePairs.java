package com.leetcode.Companies.Uber;

import java.util.*;

/**
 * Complexity of the solution:
 * Runtime Complexity: O(k^2 * n) (k = length of the longest String in the list of words, n = # of Words)
 * Space Complexity: O ((k+n)^2) (k = length of the longest String in the list of words, n = # of Words)
 */
public class PalindromePairs {
    /**
     * Checks if the substring (start to end) is a palindrome or not
     *
     * @param start Start index of the substring
     * @param end   end index of the substring
     * @param s     The String
     * @return return true if the substring from start-end is a palindrome, return false otherwise
     */
    public boolean isPalindrome(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    /**
     * Valid prefix definition: find all prefixes which,
     * when removed, makes the rest of the String a palindrome
     *
     * @param word String whose valid prefixes are to be found
     * @return returns the List of valid prefixes for the word
     */
    public List<String> validPrefix(String word) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(i, word.length() - 1, word))
                res.add(word.substring(0, i));
        }
        return res;
    }

    /**
     * Valid Suffix definition: find all suffixes which,
     * when removed, makes the rest of the String a palindrome
     *
     * @param word String whose valid suffixes are to be found
     * @return returns the List of valid suffixes for the word
     */
    public List<String> validSuffix(String word) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(0, i, word))
                res.add(word.substring(i + 1));
        }
        return res;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        //build hash table
        Map<String, Integer> wordMap = new HashMap<>();
        int i = 0;
        for (String word : words) {
            wordMap.put(word, i);
            i++;
        }
        for (String word : wordMap.keySet()) {
            String reverse = new StringBuilder(word).reverse().toString();

            /*
              for each word, check if the reverse of the word exists and add to the list
              Since, the reverse of the word comes second, we put the reverse index
              as the 2nd value while adding to the result
            */
            if (wordMap.containsKey(reverse) && !wordMap.get(word).equals(wordMap.get(reverse)))
                result.add(Arrays.asList(wordMap.get(word), wordMap.get(reverse)));

            /*
              for each word's valid prefix, check if the reverse of the prefix exists
              Since the reverse of the prefix should come at the end of the combined word,
              we put the reverse index as the 2nd index value while adding to the result
             */
            for (String prefix : validPrefix(word)) {
                String preReverse = new StringBuilder(prefix).reverse().toString();
                if (wordMap.containsKey(preReverse))
                    result.add(Arrays.asList(wordMap.get(word), wordMap.get(preReverse)));
            }
            /*
              for each word's valid suffixes, check if the reverse of the suffix exists
              Since the reverse of the suffix should come at the start of the combined word,
              we put the reverse index as the 1st index value while adding to the result
             */
            for (String suffix : validSuffix(word)) {
                String suffixReverse = new StringBuilder(suffix).reverse().toString();
                if (wordMap.containsKey(suffixReverse))
                    result.add(Arrays.asList(wordMap.get(suffixReverse), wordMap.get(word)));
            }

        }
        return result;
    }
}
