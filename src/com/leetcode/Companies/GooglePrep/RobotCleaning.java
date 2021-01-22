package com.leetcode.Companies.GooglePrep;

import java.util.HashSet;
import java.util.Set;

/*
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation */
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();
}

public class RobotCleaning {

    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        backTrack(robot, visited, 0, 0, 0);
    }

    public void backTrack(Robot robot, Set<String> visited, int i, int j, int curDir) {
        String temp = i + "->" + j;
        //if we have already cleaned this place, no need to clean it again
        if (visited.contains(temp)) return;

        //if not cleaned, then clean the box
        robot.clean();
        //add the box to visited Set.
        visited.add(temp);

        for (int n = 0; n < 4; n++) {
            if (robot.move()) {
                int x = i, y = j;
                switch (curDir) {
                    case 0:
                        x = i - 1;
                        break;
                    case 90:
                        y = j + 1;
                        break;
                    case 180:
                        x = x + 1;
                        break;
                    case 270:
                        y = j - 1;
                        break;
                    default:
                        break;
                }
                backTrack(robot, visited, x, y, curDir);
                //move back to original position and original direction to explore other directions
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            //move to the next direction
            curDir += 90;
            curDir %= 360;
            robot.turnRight();
        }
    }
}
