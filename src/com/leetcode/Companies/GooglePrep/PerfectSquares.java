package com.leetcode.Companies.GooglePrep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PerfectSquares {
    /**
     * This solution is based on Lagrange's Theorem that any number can be made up of summing 4 numbers
     * there is another variation of the same which says that we can form any number using 3 numbers
     * if its not in the form of 4^a(8b + 7). so we first check if its one by checking if the number
     * provided itself is a perfect square.
     * then we keep dividing n by 4 until its no longer divisible by 4;
     * then we check if its of the form (8b + 7) by checking num % 8 == 7; if it is, then return 4
     * else,we check for 2 and that's basically checked in a bruteforce way.
     * if none of these checks out, we simply return 3 since that is the only left option.
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (Math.ceil(Math.sqrt(n)) == Math.floor(Math.sqrt(n))) return 1;

        while (n % 4 == 0) n = n / 4;

        if (n % 8 == 7) return 4;

        Set<Integer> squares = new HashSet<>();

        for (int i = 1; i <= n / 2; i++) {
            squares.add(i * i);
        }
        for (int i = 1; i <= n / 2; i++) {
            if (squares.contains(i) && squares.contains(n - i)) return 2;
        }
        return 3;
    }
}
