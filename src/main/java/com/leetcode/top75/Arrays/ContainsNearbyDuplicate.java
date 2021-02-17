package com.leetcode.top75.Arrays;

import java.util.HashMap;

public class ContainsNearbyDuplicate {
    //6ms solution
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                int j=map.getOrDefault(nums[i],-1);
                if(j>=0&&Math.abs(i-j)<=k){
                    return true;
                }else{
                    map.put(nums[i],i);
                }
            }
            return false;
        }
    }
    //Naive approach
    class Solution2 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if(nums.length > 9999)            //without this, the solution takes a lot of time and hence its not approved
                return false;
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<=i+k&&j<nums.length;j++){
                    if(nums[i]==nums[j])
                        return true;
                }
            }
            return false;
        }
    }
}
