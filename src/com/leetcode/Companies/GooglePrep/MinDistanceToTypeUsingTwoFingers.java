package com.leetcode.Companies.GooglePrep;

public class MinDistanceToTypeUsingTwoFingers {

    /*
        All distances have to be added except for
        the biggest distance between two consecutive characters.
        This becomes very simple if the characters in the word are not repeated.

        To accommodate repeating characters, We maintain a dp array to store the max distance
        we have calculated, for each character we encounter in the word.

        For each character we try to find the max distance we have discovered
        we make a choice whether to choose current finger or the previous finger
        to jump to next character.
     */
    public int minimumDistance(String word) {
        int[] dp = new int[26];
        int res = 0;
        int save = 0;
        int n = word.length();

        for (int i = 0; i < word.length() - 1; i++) {
            int b = word.charAt(i) - 'A';
            int c = word.charAt(i + 1) - 'A';

            for (int a = 0; a < 26; a++)
                dp[b] = Math.max(dp[b], dp[a] + dist(b, c) - dist(a, c));
            save = Math.max(save, dp[b]);
            res += dist(b, c);
        }
        return res - save;


    }

    public int dist(int A, int B) {
        return Math.abs(A / 6 - B / 6) + Math.abs(A % 6 - B % 6);
    }
}
