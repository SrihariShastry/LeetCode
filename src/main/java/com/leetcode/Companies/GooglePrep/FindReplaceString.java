package com.leetcode.Companies.GooglePrep;

import java.util.Arrays;

public class FindReplaceString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int[] match = new int[S.length()];
        int i = 0;
        Arrays.fill(match, -1);
        while (i < indexes.length) {
            int ix = indexes[i];
            if (S.startsWith(sources[i], ix))
                match[ix] = i;
            i++;
        }

        int ix = 0;
        StringBuilder sb = new StringBuilder();
        while (ix < S.length()) {
            if (match[ix] >= 0) {
                sb.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            } else {
                sb.append(S.charAt(ix++));
            }
        }
        return sb.toString();
    }
}
