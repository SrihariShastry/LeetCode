package com.leetcode.Companies.GooglePrep;

import java.util.HashSet;
import java.util.Set;

public class NextTime {
    public String nextClosestTime(String time) {
        int mins = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));

        Set<Integer> valid = new HashSet<>();

        for (char c : time.toCharArray()) {
            if (c != ':') valid.add(c - '0');
        }
        boolean found = false;
        while (!found) {
            mins = (mins + 1) % (60 * 24);
            int[] nums = new int[]{mins / 60 / 10, mins / 60 % 10, mins % 60 / 10, mins % 60 % 10};
            boolean isValid = true;
            for (int num : nums) {
                if (!valid.contains(num)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) found = true;
        }
        return String.format("%02d:%02d", mins / 60, mins % 60);

    }
}
