package com.leetcode.Companies.GoldmanSachs;

import java.util.*;

public class FindSquares {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public int numSquares(int[][] points) {
        HashMap<Integer, List<Point>> distMap = new HashMap<>();
        int[][] dp = new int[points.length][points.length];

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                dp[i][j] = distance(points[i], points[j]);
                dp[j][i] = dp[i][j];
                distMap.putIfAbsent(dp[i][j], new ArrayList<>());
                distMap.get(dp[i][j]).add(new Point(points[i][0], points[i][1]));
                distMap.get(dp[i][j]).add(new Point(points[j][0], points[j][1]));
            }
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                List<Point> neighbours = distMap.get(dp[i][j]);
                res += count(i, j, neighbours, points, dp[i][j]);
            }
        }

        return res;
    }

    public int count(int i, int j, List<Point> n, int[][] points, int dist) {
        int res = 0;
        for (int r = 0; r < n.size(); r++) {
            for (int c = r + 1; c < n.size(); c++) {
                Set<Integer> d = new HashSet<>();
                d.add(dist);
                if (isSame(points[i], new int[]{n.get(r).x, n.get(r).y}) ||
                        isSame(points[j], new int[]{n.get(r).x, n.get(r).y}) ||
                        isSame(points[i], new int[]{n.get(c).x, n.get(c).y}) ||
                        isSame(points[j], new int[]{n.get(c).x, n.get(c).y})) {
                    continue;
                }

                //we already know the distance between i and j. we need distance between i and other two new points
                d.add(distance(points[i], new int[]{n.get(r).x, n.get(r).y}));
                d.add(distance(points[i], new int[]{n.get(c).x, n.get(c).y}));

                //one diagonal and two sides
                if (d.size() == 2) {
                    res++;
                }
            }
        }
        return res;
    }

    public int distance(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }

    public boolean isSame(int[] x, int[] y) {
        return x[0] == y[0] && x[1] == y[1];
    }
}
