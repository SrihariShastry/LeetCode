package com.leetcode.Companies.GooglePrep;

public class CountSquares {

    /**
     * the solution follows the basic idea behind getting the maximal square.
     * if matrix[i][j] is 1 then we take the minimum of (i-1,j-1),(i,j-1),(i-1,j), add 1 and store it in (i,j)
     * <p>
     * we increment res by adding the (i,j) value because, for example,
     * if the value is 2, the we say there is 1 square of 1x1 and 1 square of 2x2. so we add twice;
     *
     * @param matrix matrix of 0's and 1's
     * @return the number of squares that can be formed from the matrix
     */
    public int countSquares(int[][] matrix) {
        int res = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j])) + 1;
                }
                res += matrix[i][j];
            }
        }
        return res;
    }
}
