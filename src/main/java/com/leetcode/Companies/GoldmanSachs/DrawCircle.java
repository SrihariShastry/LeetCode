package com.leetcode.Companies.GoldmanSachs;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DrawCircle {

    public List<Pair<Integer, Integer>> draw(int r) {
        int left = -r;
        List<Pair<Integer, Integer>> res = new ArrayList<>();
        for (int i = left; i <= r; i++) {
            for (int j = r; j >= left; j--) {
                if (i * i + j * j == r * r) {
                    res.add(new Pair<>(i, j));
                }
            }
        }
        return res;
    }
}
