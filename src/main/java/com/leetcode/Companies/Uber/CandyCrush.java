package com.leetcode.Companies.Uber;

public class CandyCrush {

    public int[][] CandyCrush(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean todo = false;

        //First we identify all the values which are next to each other in a row.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + 2 < m; j++) {
                int v = Math.abs(board[i][j]);
                if (v != 0 && v == Math.abs(board[i][j + 1]) && v == Math.abs(board[i][j + 2])) {
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                    todo = true;
                }
            }
        }
        //Secondly we identify all the values which are next to each other vertically (column)
        for (int i = 0; i + 2 < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = Math.abs(board[i][j]);
                if (v != 0 && v == Math.abs(board[i + 1][j]) && v == Math.abs(board[i + 2][j])) {
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
                    todo = true;
                }
            }
        }
        /*
            This part is similar to move zeros to the end problem.
         */
        for (int c = 0; c < m; c++) {
            int wr = n - 1;
            for (int r = n - 1; r >= 0; r--) {
                if (board[r][c] > 0)
                    board[wr--][c] = board[r][c];
            }
            while (wr >= 0) {
                board[wr--][c] = 0;
            }
        }

        return todo ? CandyCrush(board) : board;

    }
}
