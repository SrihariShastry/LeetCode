package com.leetcode.Companies.Amazon;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class SnakeGame {

    Deque<Pair<Integer, Integer>> snake;
    HashSet<Pair<Integer, Integer>> snakePos;
    int height;
    int width;
    int foodPos;
    int[][] food;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.height = height;
        this.width = width;
        this.food = food;
        this.foodPos = 0;
        this.snakePos = new HashSet<>();
        this.snake = new ArrayDeque<>();
        this.snake.offer(new Pair<Integer, Integer>(0, 0));
        snakePos.add(new Pair<Integer, Integer>(0, 0));
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {

        Pair<Integer, Integer> curPos = snake.peekFirst();
        int curRow = curPos.getKey();
        int curCol = curPos.getValue();

        switch (direction) {
            case "U":
                curRow--;
                break;
            case "L":
                curCol--;
                break;
            case "D":
                curRow++;
                break;
            case "R":
                curCol++;
                break;
        }

        Pair<Integer, Integer> nextSnake = new Pair<Integer, Integer>(curRow, curCol);
        Pair<Integer, Integer> curTail = snake.peekLast();
        boolean crossBoundaries = (curRow < 0 || curRow >= height
                || curCol < 0 || curCol >= width);
        if (crossBoundaries || (snakePos.contains(nextSnake)
                && !(curRow == curTail.getKey() && curCol == curTail.getValue()))) {
            return -1;
        }
        if (foodPos < food.length && curRow == food[foodPos][0]
                && curCol == food[foodPos][1]) {
            //check if cur pos of the snake has food
            this.foodPos++;

        } else {
            //move the snake
            snake.pollLast();
            snakePos.remove(curTail);
        }
        snake.offerFirst(nextSnake);
        snakePos.add(nextSnake);

        return snake.size() - 1;

    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

