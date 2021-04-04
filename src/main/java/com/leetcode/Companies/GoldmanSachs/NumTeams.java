package com.leetcode.Companies.GoldmanSachs;

public class NumTeams {
    public int numTeams(int[] rating) {

        int res = 0;
        int n = rating.length;
        for (int i = 0; i < rating.length; i++) {
            int rightBig = 0;
            int leftBig = 0;
            int rightSmall = 0;
            int leftSmall = 0;

            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) leftSmall++;
                if (rating[j] > rating[i]) leftBig++;
            }

            for (int k = i + 1; k < n; k++) {
                if (rating[k] > rating[i]) rightBig++;
                if (rating[k] < rating[i]) rightSmall++;
            }

            res += rightBig * leftSmall + leftBig * rightSmall;
        }

        return res;

    }
}
