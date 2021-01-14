package com.leetcode.top75.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (char c : S.toCharArray()) {
            map.put(c, i);
            i++;
        }
        int max = map.get(S.charAt(0));
        int prevPartition = 0;
        List<Integer> res = new ArrayList<>();
        for (i = 0; i < S.length(); i++) {

            if (map.get(S.charAt(i)) > max || i > max)
                max = map.get(S.charAt(i));
            if (i == max) {
                res.add(i - prevPartition + 1);
                prevPartition = i + 1;
            }

        }
        if (prevPartition < i)
            res.add(i - prevPartition);

        return res;
    }
}
