package com.leetcode.Uber;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        TrieNode root = new TrieNode();
        result = new ArrayList<>();

        //construct Trie
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(c, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        //Check if any of the words start with the character in board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtrack(i, j, board, root);
                }
            }
        }
        return result;

    }

    public void backtrack(int i, int j, char[][] board, TrieNode parent) {
        int n = board.length;
        int m = board[0].length;
        char c = board[i][j];
        TrieNode current = parent.children.get(board[i][j]);
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        //we are at the end of the path. acknowledge that we found the word by adding it to result
        if (current.word != null) {
            result.add(current.word);
            current.word = null;
        }
        //set visited
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int[] newDir = dir[k];
            int row = i + newDir[0];
            int col = j + newDir[1];
            //check for bounds
            if (row >= n || col >= m || row < 0 || col < 0) continue;
            //check if we can move down the tree;
            if (current.children.containsKey(board[row][col])) {
                backtrack(row, col, board, current);
            }
        }

        //backtracking
        board[i][j] = c;

        if (current.children.isEmpty()) {
            parent.children.remove(c);
        }
    }

}
