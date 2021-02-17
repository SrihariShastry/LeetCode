package com.leetcode.Companies.GooglePrep;

import java.util.ArrayList;

public class SumNumbers {
    /**
     * First, we collect all the numbers from the string on to a stack.
     * then we pop the stack and add all the numbers to the sum.
     *
     * @param str Input String
     * @return Sum of numbers in the string
     */
    public static int sumNumbers(String str) {
        ArrayList<Integer> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) sb.append(c);
            else if (sb.length() > 0) {
                res.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) res.add(Integer.parseInt(sb.toString()));
        int sum = 0;
        for (int num : res) {
            sum += num;
        }
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(sumNumbers("aa11b33"));
    }

}
