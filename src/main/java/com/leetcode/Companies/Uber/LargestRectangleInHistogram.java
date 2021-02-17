package com.leetcode.Companies.Uber;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    /**
     * For this problem, we'll use a stack to keep track of the  histogram heights
     * <p>
     * we put all the indexes of heights that are bigger than the previous ones.
     * If and when we encounter a height that is smaller than the stack top,
     * we can conclude that all the heights that are bigger than the
     * current height can be removed from the stack and their heights will be calculated
     * <p>
     * The way we calculate the height of the rectangle is by looking at where the current rectangle
     * started.
     * <p>
     * i - stack.peekFirst() -1 will give us the index where our current height started.
     * i - stack.peekFirst() -1 is the width of the rectangle. we multiply the width with the height
     * to get the area of the rectangle.
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max;
        int res = 0;
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peekFirst()] <= heights[i]) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                if (stack.isEmpty()) {
                    max = heights[top] * i;
                } else {
                    max = heights[top] * (i - stack.peekFirst() - 1);
                }
                res = Math.max(res, max);
            }
        }

        /*
          Lastly, until the stack is empty, we repeat the same process as above
          to make sure that we get the max height.
         */
        while (!stack.isEmpty()) {
            int top = stack.pollFirst();
            if (stack.isEmpty()) {
                max = heights[top] * i;
            } else {
                max = heights[top] * (i - stack.peekFirst() - 1);
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
