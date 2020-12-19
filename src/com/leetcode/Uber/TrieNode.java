package com.leetcode.Uber;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children;
    String word;

    public TrieNode() {
        children = new HashMap<>();
        word = null;
    }
}
