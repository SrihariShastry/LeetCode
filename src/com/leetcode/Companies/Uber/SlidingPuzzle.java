package com.leetcode.Companies.Uber;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class SlidingPuzzle {
    /**
     * This solution takes a BFS approach and we generate permutations of the board state and check
     * if we can reach the destination.
     * <p>
     * Each board state is a node and we need a way to shift the board state by swapping 0 with
     * its neighboring indexes.
     * dirs array defines the neighboring indexes we can visit when 0 is in that respective position
     * <p>
     * The rest is a BFS solution.
     *
     * @param board 2 x 3 board with misplaced numbers
     * @return number of moves required to bring the state of the board to 123450
     */
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int col : row) {
                start.append(col);
            }
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();

        q.offer(start.toString());
        visited.add(start.toString());
        int res = 0;
        int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) return res;
                int idx = cur.indexOf('0');

                for (int dir : dirs[idx]) {
                    String perm = swap(cur, idx, dir);
                    if (visited.add(perm)) q.offer(perm);
                }
            }
            res++;
        }
        return -1;
    }

    public String swap(String str, int zero, int target) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(zero, str.charAt(target));
        sb.setCharAt(target, str.charAt(zero));
        return sb.toString();
    }
}
