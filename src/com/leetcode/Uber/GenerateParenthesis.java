package com.leetcode.Uber;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack("", 0, 0, n);
        return res;
    }

    public void backtrack(String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }

        if (open < max) backtrack(cur + "(", open + 1, close, max);
        if (close < open) backtrack(cur + ")", open, close + 1, max);
    }

}
