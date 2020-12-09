package com.leetcode.Uber;

public class SortColors {

    public void sortColors(int[] colors) {
        int lo = 0;
        int hi = colors.length - 1;
        int i = 0;
        // important while condition because we know that every element after hi is going to be 2
        // so we don't have to traverse beyond high
        while (i <= hi) {
            if (colors[i] == 0) swap(colors, lo++, i);
            else if (colors[i] == 2) swap(colors, hi--, i);
            i++;
        }

    }

    public void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
