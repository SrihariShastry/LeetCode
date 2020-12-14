package com.leetcode.Uber;

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
