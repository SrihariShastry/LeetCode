package com.leetcode.Companies.GoldmanSachs;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        low = new PriorityQueue<>((a, b) -> b - a);
        high = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (low.isEmpty() || num < low.peek())
            low.offer(num);
        else
            high.offer(num);

        balance();
    }

    public void balance() {

        if (high.size() == low.size())
            return;

        PriorityQueue<Integer> bigger = low.size() > high.size() ? low : high;
        PriorityQueue<Integer> smaller = low.size() < high.size() ? low : high;

        while (bigger.size() - smaller.size() >= 2) {
            smaller.offer(bigger.poll());
        }
    }

    public double findMedian() {
        PriorityQueue<Integer> bigger = low.size() > high.size() ? low : high;
        PriorityQueue<Integer> smaller = low.size() > high.size() ? high : low;

        if (bigger.size() == smaller.size()) {
            return (low.peek() + high.peek()) / 2.0;
        } else {
            return (double) bigger.peek();
        }
    }
}
