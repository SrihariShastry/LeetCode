package com.leetcode.Companies.GoldmanSachs;

import java.util.stream.IntStream;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        long expectedSum = (long) n * (n + 1) / 2;
        long sum = 0;
//
//        for(int num:nums){
//            sum+=num;
//        }
        sum = IntStream.of(nums).sum();

        return (int) (expectedSum - sum);
    }
}
