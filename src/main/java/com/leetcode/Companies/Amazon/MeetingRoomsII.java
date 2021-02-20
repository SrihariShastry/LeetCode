package com.leetcode.Companies.Amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> rooms =
                new PriorityQueue<Integer>(intervals.length, (a, b) -> a - b);

        rooms.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            // if room can be freed, then free the room
            if (intervals[i][0] >= rooms.peek()) {
                rooms.poll();
            }
            rooms.add(intervals[i][1]);

        }
        return rooms.size();
    }
}
