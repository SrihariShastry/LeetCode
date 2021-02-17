package com.leetcode.Companies.Uber;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int level = 1;
        if (!set.contains(endWord)) return 0;

        q.offer(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String qWord = q.poll();
                char[] qChar = qWord.toCharArray();
                for (int j = 0; j < qChar.length; j++) {
                    char originalChar = qChar[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        qChar[j] = c;
                        String variation = String.valueOf(qChar);
                        // check if we reached end word
                        if (endWord.equals(variation)) return level + 1;
                        //check if we have the variation inside our set
                        if (set.contains(variation)) {
                            q.offer(variation);
                            set.remove(variation);  //avoid duplicates
                        }

                    }
                    qChar[j] = originalChar;
                }
            }

            ++level;
        }

        return 0;
    }
}
