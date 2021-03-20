package com.leetcode.Companies.GoldmanSachs;

public class RobotReturn {
    public boolean judgeCircle(String moves) {
        //Initial x,y position
        int x = 0;
        int y = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'U') x--;
            else if (c == 'D') x++;
            else if (c == 'L') y--;
            else if (c == 'R') y++;
        }

        return x == 0 && y == 0;
    }
}
