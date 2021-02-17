package com.leetcode.Companies.Amazon;

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] count = new int[26];
        int max = releaseTimes[0];
        count[keysPressed.charAt(0) - 'a'] = releaseTimes[0];

        //for every character get the max time and record the max time
        for (int i = 1; i < keysPressed.length(); i++) {
            char c = keysPressed.charAt(i);
            count[c - 'a'] = Math.max(count[c - 'a'], releaseTimes[i] - releaseTimes[i - 1]);
            max = Math.max(max, count[c - 'a']);
        }

        //traverse in reverse to get the lexicographically bigger character with max time
        char res = keysPressed.charAt(0);
        for (int j = 25; j >= 0; j--)
            if (count[j] == max) {
                res = (char) (j + 'a');
                break;
            }

        return res;
    }
}
