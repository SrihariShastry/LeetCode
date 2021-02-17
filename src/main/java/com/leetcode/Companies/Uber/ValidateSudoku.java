package com.leetcode.Companies.Uber;

import java.util.HashMap;

public class ValidateSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] row = new HashMap[9];
        HashMap<Integer, Integer>[] col = new HashMap[9];
        HashMap<Integer, Integer>[] box = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            box[i] = new HashMap<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    int boxIdx = (i / 3) * 3 + (j / 3);
                    int num = board[i][j] - '0';
                    if (row[i].containsKey(num) || col[j].containsKey(num) || box[boxIdx].containsKey(num))
                        return false;
                    row[i].put(num, row[i].getOrDefault(num, 0) + 1);
                    col[j].put(num, col[j].getOrDefault(num, 0) + 1);
                    box[boxIdx].put(num, box[boxIdx].getOrDefault(num, 0) + 1);

                }
            }
        }
        return true;
    }
}
