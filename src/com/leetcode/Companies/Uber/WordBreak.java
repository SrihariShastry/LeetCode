package com.leetcode.Companies.Uber;

import java.util.*;

public class WordBreak {
    /**
     * In this , we are going to use BFS to see if we can match any word present in the set
     *
     * @param s    String
     * @param dict List of strings to match
     * @return
     */
    public boolean wordBreak(String s, List<String> dict) {
        Set<String> wordDict = new HashSet<>(dict);
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[s.length()];
        q.add(0);
        while (!q.isEmpty()) {
            int start = q.poll();
            if (!visited[start])
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDict.contains(s.substring(start, end))) {
                        q.offer(end);
                        visited[start] = true;
                        if (end == s.length()) return true;
                    }
                }
        }
        return false;

    }

    public boolean wordBreak2(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> wordDict = new HashSet<>(dict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
