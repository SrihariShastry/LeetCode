package com.leetcode.Companies.Amazon;

public class SearchIn2D {

    /**
     * Since the matrix is formed in such a way that:
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     * <p>
     * We start with last row and first column and
     * decrease row if target is less than matrix[i][j]
     * increase column if target is greater than matrix[i][j]
     * <p>
     * we do this until we either find the element or we go out of bounds.
     *
     * @param matrix input matrix
     * @param target target number to search
     * @return return true if target found, false otherwise.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) row--;
            else if (matrix[row][col] < target) col++;
        }

        return false;
    }
}
