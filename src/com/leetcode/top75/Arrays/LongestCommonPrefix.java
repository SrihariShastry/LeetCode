package com.leetcode.top75.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int min = Integer.MAX_VALUE;
        int j = 0;
        while (j < strs.length) {
            min = Math.min(min, strs[j].length());
            j++;
        }
        j = 0;
        StringBuilder sb = new StringBuilder();
        while (j < min) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(j) != c)
                    return sb.toString();
            }
            j++;
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("longest common prefix: " + new LongestCommonPrefix().longestCommonPrefix(new String[]{}));
    }
}
