package com.leetcode.Companies.GoldmanSachs;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0) return res;

        int rowE = matrix.length - 1;
        int colE = matrix[0].length - 1;
        int rowB = 0;
        int colB = 0;

        while (rowB <= rowE && colB <= colE) {

            //traverse Right
            for (int j = colB; j <= colE; j++) {
                res.add(matrix[rowB][j]);
            }
            rowB++;

            //traverse Down

            for (int j = rowB; j <= rowE; j++) {
                res.add(matrix[j][colE]);
            }
            colE--;


            // traverse Left
            if (rowB <= rowE) {
                for (int j = colE; j >= colB; j--) {
                    res.add(matrix[rowE][j]);
                }
                rowE--;
            }

            // traverse up
            if (colB <= colE) {
                for (int j = rowE; j >= rowB; j--) {
                    res.add(matrix[j][colB]);
                }
                colB++;
            }
        }

        return res;
    }
}
