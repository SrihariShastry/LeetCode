package com.leetcode.top75.Graphs;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {

        HashMap<Character, List<Character>> adj = new HashMap<>();
        HashMap<Character, Integer> counts = new HashMap<>();

        //collect all unique letters
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.put(c, new ArrayList<>());
                counts.put(c, 0);
            }
        }

        //Build Adjacency graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
                /*
                /*if the first word which is lexicographically placed before the second word
                /* happens to be bigger in length and if the first word starts with second word
                /* return empty since its not a valid dictionary.
                /* ex: "adds" coming before "add" in english dictionary
                 */
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";

            /*
             * check the point where the words start to differ
             * since first word's character should appear before the second
             * we say that second word's character at `j` is supposed to be
             * dependent on first word's character at `j`
             * and the number of in-degrees for second word will be increased by 1
             */
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));

                    counts.put(w2.charAt(j), counts.get(w2.charAt(j)) + 1);
                    break;
                }
            }
        }

        //BFS
        // This part is extremely similar to Course Scheduling
        // We add all the characters with in-degree 0
        Queue<Character> q = new LinkedList<>();
        for (char c : counts.keySet()) {
            if (counts.get(c) == 0) {
                q.offer(c);
            }
        }

        //we then get each character from the queue, append it to result,
        // and decrease the in-degree count by 1 for each of the adjacent characters/nodes
        //if, after decrementing, the in-degree of the adjacent character becomes 0,
        // we add the character to the queue.
        while (!q.isEmpty()) {
            char c = q.poll();
            res.append(c);
            for (char key : adj.get(c)) {
                counts.put(key, counts.get(key) - 1);
                if (counts.get(key) == 0)
                    q.offer(key);
            }
        }
        /*
         * if the length of the result calculated is not equal
         * to the number of unique Characters in the dictionary
         * Then we know for a fact that the Dictionary is not formed properly
         * and that the order is not a valid order.
         * */
        return counts.size() > res.length() ? "" : res.toString();


    }
}
