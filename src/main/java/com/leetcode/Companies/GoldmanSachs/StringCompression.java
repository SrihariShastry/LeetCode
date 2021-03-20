package com.leetcode.Companies.GoldmanSachs;

public class StringCompression {

    public int compress(char[] chars) {
        int read = 0;
        int write = 0;
        while (read < chars.length) {
            char cur = chars[read];
            int count = 0;
            while (read < chars.length && chars[read] == cur) {
                read++;
                count++;
            }
            chars[write++] = cur;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;

    }
}
