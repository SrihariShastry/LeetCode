package com.leetcode.Companies.Amazon;

public class RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {
        int curDir = 0;
        /*
         * Up = x - 1
         * Right = y + 1
         * Left = y - 1;
         * down = x + 1;
         */
        int x = 0, y = 0; // initial position
        for (char c : instructions.toCharArray()) {
            switch (c) {
                case 'G':
                    switch (curDir % 4) {
                        case 0:
                            x -= 1;
                            break;
                        case 1:
                            y += 1;
                            break;
                        case 2:
                            x += 1;
                            break;
                        case 3:
                            y -= 1;
                            break;
                    }

                case 'L':
                    curDir += 3;
                    break;
                case 'R':
                    curDir += 1;
                    break;
            }
        }

        /*
         * Basically stating that if we have returned to original position or
         * if we have changed direction at any point during our traversal,
         * we are bound to come back to our original position(run the directions on loop
         */
        return (x == 0 && y == 0) || (curDir % 4) != 0;
    }
}

