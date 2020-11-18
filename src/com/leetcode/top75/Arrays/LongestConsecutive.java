package com.leetcode.top75.Arrays;

import java.util.HashSet;
import java.util.Set;

/* LC: 128 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //collect all nums in the set
        for (int i : nums) {
            set.add(i);
        }
        int maxLen = 0;
        int longestStreak = 0;

        //loop through numbers
        for (int n : nums) {
            //check if this is the first number in the sequence
            if (!set.contains(n - 1)) {

                int currentNum = n;
                longestStreak = 1;
                //get the length of the sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    longestStreak++;
                }
                //Check the max length
                maxLen = Math.max(maxLen, longestStreak);
            }
        }

        return maxLen;
    }
}
