package com.leetcode.Companies.Uber;

import java.util.LinkedList;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();

        int j = 0;

        while (j < asteroids.length) {
            if (list.isEmpty() || list.peekLast() < 0 || asteroids[j] > 0) {
                list.offerLast(asteroids[j]);
            } else if (asteroids[j] < 0 && list.peekLast() < -asteroids[j]) {
                list.pollLast();
                continue;
            } else if (asteroids[j] < 0 && list.peekLast() == -asteroids[j])
                list.pollLast();

            j++;
        }
        int[] res = new int[list.size()];

        int i = 0;
        while (!list.isEmpty())
            res[i++] = list.poll();

        return res;
    }
}
