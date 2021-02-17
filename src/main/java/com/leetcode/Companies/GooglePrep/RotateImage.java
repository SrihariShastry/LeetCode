package com.leetcode.Companies.GooglePrep;

/**
 * Idea is to transpose the matrix and then swap the first half columns with last half columns
 * similar to two pointer approach
 */
public class RotateImage {
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        swap(matrix);
    }

    private void swap(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix.length - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
