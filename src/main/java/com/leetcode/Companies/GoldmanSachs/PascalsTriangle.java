package com.leetcode.Companies.GoldmanSachs;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();

        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> curRow = new ArrayList<>();

            curRow.add(1);
            for (int j = 1; j < i; j++)
                curRow.add(prevRow.get(j - 1) + prevRow.get(j));
            curRow.add(1);

            triangle.add(curRow);
        }

        return triangle;
    }
}
