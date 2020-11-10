package com.leetcode.top75.Arrays;

import java.util.Stack;

public class DecodeString {

    static class Solution {
        public String decodeString(String s) {

            Stack<Integer> numberStack = new Stack<>();
            Stack<StringBuilder> stringStack = new Stack<>();
            StringBuilder currentString = new StringBuilder();
            StringBuilder decodeString;
            int k = 0;

            for (char ch : s.toCharArray()) {

                if (ch == '[') {
                    stringStack.push(currentString);
                    currentString = new StringBuilder();

                    numberStack.push(k);
                    k = 0;
                } else if (ch == ']') {
                    decodeString = stringStack.pop();
                    for (int i = numberStack.pop(); i > 0; i--) {
                        decodeString.append(currentString);
                    }
                    currentString = decodeString;
                } else if (Character.isDigit(ch)) {
                    k = k * 10 + ch - '0';

                } else {
                    currentString.append(ch);
                }
            }
            return currentString.toString();
        }
    }
}
