package com.leetcode.top75;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{};
        int target =9;
        int[] res = new int[2];
        res = twoSum(nums,target);
    }
    private static int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0]=i;
                res[1] = map.get(target-nums[i]);
                break;
            }
            else
                map.put(nums[i],i);

        }
        return res;
    }
}
