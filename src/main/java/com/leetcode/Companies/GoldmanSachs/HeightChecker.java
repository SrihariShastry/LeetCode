package com.leetcode.Companies.GoldmanSachs;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] heightToFreq = new int[101];
        for (int height : heights)
            heightToFreq[height]++;
        int cur = 0;
        int res = 0;

        for (int height : heights) {
            while (heightToFreq[cur] == 0) cur++;

            if (cur != height)
                res++;
            heightToFreq[cur]--;
        }

        return res;
    }
}
