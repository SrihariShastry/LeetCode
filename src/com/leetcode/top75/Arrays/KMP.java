package com.leetcode.top75.Arrays;

public class KMP {

    int[] lps;

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;
        lps = new int[needle.length()];

        ConstructPI(needle, needle.length());

        int i = 0;
        int j = 0;

        while (i < haystack.length()) {
            if (j == needle.length()) {
                return i - j;
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (haystack.charAt(i) != needle.charAt(j)) {

                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    public void ConstructPI(String n, int l) {
        int i = 1;
        int j = 0;

        while (i < l) {
            if (n.charAt(j) == n.charAt(i)) {
                lps[i++] = ++j;
            } else {

                if (j == 0) {
                    lps[i] = j;
                    i++;
                } else {
                    j = lps[j - 1];
                }

            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Needle Position: " + new KMP().strStr("Hello", "ll"));
    }
}
