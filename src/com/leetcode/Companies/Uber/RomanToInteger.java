package com.leetcode.Companies.Uber;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> values = new HashMap<>();

        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);

        int res = 0;
        int i = 0;
        while (i < s.length()) {
            String cur = s.substring(i, i + 1);
            int curVal = values.get(cur);
            int nextVal = 0;
            if (i + 1 < s.length()) {
                String next = s.substring(i + 1, i + 2);
                nextVal = values.get(next);
            }
            if (curVal < nextVal) {
                res += (nextVal - curVal);
                i += 2;
            } else {
                res += curVal;
                i++;
            }
        }
        return res;
    }
}
