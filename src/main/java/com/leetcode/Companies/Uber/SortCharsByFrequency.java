package com.leetcode.Companies.Uber;

import java.util.*;

public class SortCharsByFrequency {

    /**
     * We will use bucket Sort in this approach.
     * First, we wil count the characters,
     * Second, we will place the characters based on the count of their frequency
     * <p>
     * Lastly, We repeat the characters according to the bucket number and we finally return the String
     *
     * @param s String
     * @return a String sorted according to character frequency
     */
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) return "";
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int max = Collections.max(count.values());

        //initialize bucket
        List<Character>[] bucket = new List[max + 1];
        for (int i = 0; i <= max; i++) {
            bucket[i] = new ArrayList<>();
        }

        //add characters to bucket
        for (char c : count.keySet()) {
            bucket[count.get(c)].add(c);
        }
        StringBuilder res = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            for (char c : bucket[i]) {
                String rep = c + "";
                res.append(rep.repeat(i));
            }
        }

        return res.toString();

    }

}
