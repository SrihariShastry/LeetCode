package com.leetcode.Companies.Amazon;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        int i = 0;
        for (char c : S.toCharArray()) {
            lastIndex[c - 'a'] = i;
            i++;
        }

        List<Integer> partitions = new ArrayList<>();
        i = 0;
        int j;
        int limit = 0;
        for (j = 0; j < S.length(); j++) {

            limit = Math.max(limit, lastIndex[S.charAt(j) - 'a']);
            if (j == limit) {
                partitions.add(j - i + 1);
                i = j + 1;
            }
        }

        if (j != i) partitions.add(j - i);
        return partitions;

    }
}
