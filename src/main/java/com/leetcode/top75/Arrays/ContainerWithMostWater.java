package com.leetcode.top75.Arrays;

public class ContainerWithMostWater {
    class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int maxWater = 0;
            while (l < r) {
//                maxWater = Math.max(maxWater, Math.min(height[l], height[r]) * (r - l));
//                if (height[l] < height[r])
//                    l++;
//                else
//                    r--;
                maxWater = Math.max(maxWater, (r - l) * (height[l] < height[r] ? height[l++] : height[r--]));
            }
            return maxWater;
        }
    }
}
