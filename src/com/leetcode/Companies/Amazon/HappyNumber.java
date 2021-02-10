package com.leetcode.Companies.Amazon;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean happyNumber(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) return false;
            seen.add(n);
            n = getNext(n);
        }
        return true;
    }

    public int getNext(int n) {
        int res = 0;
        while (n != 0) {
            int d = n % 10;
            res += d * d;
            n = n / 10;
        }
        return res;
    }
}
