package com.leetcode.Companies.GooglePrep;

import java.util.Stack;

public class baseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> scores = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "C" -> scores.pop();
                case "D" -> scores.push(2 * scores.peek());
                case "+" -> {
                    int prev1 = scores.pop();
                    int prev2 = scores.peek();
                    scores.push(prev1);
                    scores.push(prev1 + prev2);
                }
                default -> scores.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while (!scores.isEmpty()) {
            sum += scores.pop();
        }

        return sum;
    }
}
