package com.leetcode.Companies.GoldmanSachs;

public class FractionAdditionAndSubtraction {


    public String fractionAddition(String expression) {
        int A = 0;
        int B = 1;
        int a, b;


        /*
            The character is either a "/" or a +/- sign. (?=[])
            our regex looks for character(s) that have + or - after them.
            Ignores the after character and takes the String Chunk that is there before it
         */
        String[] nums = expression.split("/|(?=[-+])");
        int i = 0;
        while (i < nums.length) {
            a = Integer.getInteger(nums[i++]);
            b = Integer.getInteger(nums[i++]);

            //calculate the numerator
            A = A * b + B * a;

            //get the common denominator
            B = b * B;

            //get the greatest common divisor
            int gcd = GCD(A, B);

            //reduce the numerator and the denominator using the gcd
            A /= gcd;
            B /= gcd;
        }
        return A + "/" + B;
    }

    private int GCD(int a, int b) {
        if (a == 0)
            return Math.abs(b);
        return GCD(b % a, a);
    }
}
