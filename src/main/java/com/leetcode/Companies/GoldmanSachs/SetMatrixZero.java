package com.leetcode.Companies.GoldmanSachs;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean isCol = false;
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) isCol = true;
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //0th column is taken care by isCol
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (isCol) matrix[i][0] = 0;
        }
    }
}
