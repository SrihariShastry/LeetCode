package com.leetcode.Companies.Uber;

import java.util.LinkedList;

public class AsteroidCollision {
    /**
     * THis problem has 3 conditions:
     * 1. if the stack is empty or if the number at the top of the stack is -ve(it's already going left)
     * or if the number being inserted is positive.
     * 2. if there is a collision and if the the number on top of the stack is less than the one
     * being inserted
     * 3. if there is a collision and the top of the stack number and the one being inserted is the
     * negative counterpart(both would get destroyed)
     * <p>
     * Note: we do not consider asteroids which are of lesser size because they would be anyway
     * not be considered to be inserted on to the stack
     *
     * @param asteroids input array
     * @return return the final list of asteroids
     */
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
