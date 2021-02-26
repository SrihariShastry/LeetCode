package com.leetcode.Companies.GooglePrep;

import java.util.Comparator;
import java.util.TreeSet;

public class MyCalendar {
    TreeSet<int[]> cal;

    public MyCalendar() {
        cal = new TreeSet<>(Comparator.comparingInt(value -> value[0]));
    }

    public boolean book(int start, int end) {
        int[] book = new int[]{start, end};
        int[] floor = cal.floor(book);
        int[] ceil = cal.ceiling(book);

        if ((floor != null && floor[1] > start) || (ceil != null && ceil[0] < end)) return false;

        cal.add(book);
        return true;
    }
}
