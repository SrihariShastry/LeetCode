package com.leetcode.Companies.Amazon;

/*
 * Time: O(MN) M = num of rows; N = Number of cols
 * Space: O(1);
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {

        //2 if it was dead and came back to life
        //-1 if it was alive and it became dead after
        int[][] dirs = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //calculate live neighbours
                int liveN = 0;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && y >= 0 && x < board.length && y < board[0].length
                            && Math.abs(board[x][y]) == 1) {
                        liveN += 1;
                    }
                }
                //dies of over population or under population
                if (board[i][j] == 1 && (liveN < 2 || liveN > 3))
                    board[i][j] = -1;
                //became alive because 3 neighboring values
                if (board[i][j] == 0 && liveN == 3)
                    board[i][j] = 2;

            }
        }

        //update the cells
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }

    }
}
