package com.leetcode.Companies.Amazon;

class TicTacToe {

    /**
     * Initialize your data structure here.
     */
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int capacity;

    public TicTacToe(int n) {
        capacity = n;
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) diagonal += toAdd;

        if (row + col == capacity - 1) antiDiagonal += toAdd;

        if (Math.abs(rows[row]) == capacity
                || Math.abs(cols[col]) == capacity
                || Math.abs(diagonal) == capacity
                || Math.abs(antiDiagonal) == capacity) return player;

        return 0;
    }
}
