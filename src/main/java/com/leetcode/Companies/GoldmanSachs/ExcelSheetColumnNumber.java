package com.leetcode.Companies.GoldmanSachs;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int n = columnTitle.length();

        for (char c : columnTitle.toCharArray()) {
            res *= 26;

            res += (c - 'A' + 1);
        }
        return res;
    }
}
