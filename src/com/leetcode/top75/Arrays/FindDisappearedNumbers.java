package com.leetcode.top75.Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for(int i=0;i<nums.length;i++){
                //duplicates handling
                int val = Math.abs(nums[i])-1;
                if(nums[val]>0)
                    //negate nums[nums[i]-1] value
                    nums[val]= -nums[val];

            }
            List<Integer> res = new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++){
                //identify the missing number
                if(nums[i]>0)
                    res.add(i+1);
            }
            return res;

        }
    }
}
