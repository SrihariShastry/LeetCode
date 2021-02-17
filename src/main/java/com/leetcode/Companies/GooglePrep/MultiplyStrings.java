package com.leetcode.Companies.GooglePrep;

/**
 * We take the normal pen-paper approach to solving the number multiplication.
 * if, for example we take 9 x 9,
 * which is equal to 18 the p1 pointer would take 1 and the p2 pointer would contain 8
 * <p>
 * we add the p2 value to make sure we don't omit the carry.
 * we omit the leading 0's with by checking the StringBuilder size and the value
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] sum = new int[n + m];
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = i + j + 1;
                int temp = sum[p2] + ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));

                sum[p1] += temp / 10;
                sum[p2] = temp % 10;
            }
        }
        for (int p : sum) {
            if (!(sb.length() == 0 && p == 0)) sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
