package com.leetcode.Companies.GooglePrep;

public class ShortestWayString {
    public Integer shortestWay(String source, String target) {
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < target.length()) {
            int oriI = i;
            j = 0;
            while (j < source.length()) {
                if (i < target.length() && source.charAt(j) == target.charAt(i)) {
                    i++;
                }
                j++;
            }
            if (oriI == i) return -1;
            count++;
        }
        return count;
    }

}
