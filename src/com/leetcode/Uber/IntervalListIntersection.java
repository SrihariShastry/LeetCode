package com.leetcode.Uber;

import java.util.ArrayList;

public class IntervalListIntersection {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
//            int[] first =new int[2];
//            int[] sec =new int[2];

            if (A[i][1] >= B[j][0]) {
                if (B[j][1] >= A[i][0]) {
                    int[] temp = new int[2];
                    temp[0] = Math.max(A[i][0], B[j][0]);
                    temp[1] = Math.min(A[i][1], B[j][1]);
                    res.add(temp);
                }
            }
            if (A[i][1] < B[j][1]) i++;
            else j++;

//            if(A[i][1]<B[j][1]){
//                first = A[i];
//                sec= B[j];
//                i++;
//            }
//            else{
//                first=B[j];
//                sec=A[i];
//                j++;
//              }
//            //check for overlapping
//            if(sec[0]<=first[1]){
//                int[] temp = new int[2];
//                temp[0]=Math.max(first[0],sec[0]);
//                temp[1]=Math.min(first[1],sec[1]);
//                res.add(temp);
//            }

        }
        return res.toArray(new int[res.size()][2]);
    }
}
