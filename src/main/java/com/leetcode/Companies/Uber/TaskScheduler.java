package com.leetcode.Companies.Uber;

import java.util.Arrays;

/**
 * First, we get the count of each character that appears in the tasks;
 * Next, we sort the count array to access the max Count.
 * Then, we calculate idle slots needed for the max tasks.
 * <p>
 * We try to fill the idle slots as many tasks as we can while maintaining the coolDown rule
 * if the number Idle slots go below 0, then we can only assume that there are different types of
 * tasks which can be scheduled next to each other without violating the coll down rule.
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int coolDown) {
        int idleSlots = 0;
        int max = 0;
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        max = count[25];
        idleSlots = (max - 1) * coolDown;
        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(max - 1, count[i]);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
