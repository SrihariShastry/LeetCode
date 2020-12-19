package com.leetcode.Companies.Uber;

/**
 * Steps:
 * 1. We get the count of each character in the string
 * 2. we find the max count and the letter which repeats max times
 * 3. We check if the max amount is greater than half of the string. If yes, return empty string
 * 4. We first need to place the most repeated character first. we place it on even indexes
 * 5. We then place all the other Characters on odd indexes.
 * 6. If at any stage, we find that the index has gone out of bounds we just initialize it to 1;
 */
public class ReorganizeLetters {

    public String reorganizeString(String s) {
        int[] heap = new int[26];
        int letter = 0;
        int max = 0;
        int idx = 0;
        char[] res = new char[s.length()];

        for (char c : s.toCharArray()) {
            heap[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (heap[i] > max) {
                max = heap[i];
                letter = i;
            }
        }
        if (max > (s.length() + 1) / 2) return "";

        while (heap[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            heap[letter]--;
        }

        for (int i = 0; i < 26; i++) {
            while (heap[i] > 0) {
                if (idx >= s.length()) idx = 1;

                res[idx] = (char) (i + 'a');
                idx += 2;
                heap[i]--;
            }
        }
        return String.valueOf(res);
    }
}
