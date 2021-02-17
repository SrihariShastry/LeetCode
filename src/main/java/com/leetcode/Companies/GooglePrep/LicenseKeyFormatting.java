package com.leetcode.Companies.GooglePrep;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int i = s.length() - 1;

        while (i >= 0) {
            char c = s.charAt(i);
            if (c == '-') {
                i--;
                continue;
            }
            if (c >= 'a' && c <= 'z') c = Character.toUpperCase(c);

            if (sb.length() > 0 && count == 0) sb.append('-');

            sb.append(c);
            count++;
            if (count == k) count = 0;
            i--;
        }

        return sb.reverse().toString();
    }
}
