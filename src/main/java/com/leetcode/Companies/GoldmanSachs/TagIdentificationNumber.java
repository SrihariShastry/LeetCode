package com.leetcode.Companies.GoldmanSachs;

public class TagIdentificationNumber {

    public int findTID(String pool) {
        int countOfTarget = count(pool, '8');
        int div = pool.length() / 11;
        return Math.min(div, countOfTarget);
    }

    public int count(String pool, char target) {
        int count = 0;
        for (char c : pool.toCharArray()) {
            if (c == target)
                count++;
        }

        return count;
    }
}
