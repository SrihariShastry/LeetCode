package com.leetcode.top75.DP;

public class JumpProblem {
    class Solution {
        public boolean canJump(int[] nums) {
            int lastInd = nums.length-1;
            for(int i=nums.length-1;i>=0;i--){
                if(i+nums[i]>=lastInd)
                    lastInd=i;
            }
            return lastInd==0;
        }
    }
    class Solution2{
        /*
        * This solution is based on the intuition that we need to avoid 0's in the array.
        * If, however, we do encounter a 0, we need to make sure that there exists an integer in the array
        * that can jump over this 0 in order to reach the end of the array
        * then we can continue from that position and try to reach the start of the array
        * We initially start from nums.length-2 because if the last position has 0 then it still will be a good index
        * whereas if nums[nums.length-2] is 0, then there is no way of reaching the end index from this index
        * Hence we try to find an element that can jump over this element by following the while logic below
        * */
        public boolean canJump(int[] nums){
            for(int curr = nums.length-2;curr>=0;curr--){
                if(nums[curr]==0){
                    int jumps = 1;
                    while(jumps>nums[curr]){
                        jumps++;
                        curr--;
                        if(curr<0)return false;
                    }
                }
            }
            return true;
        }
    }
}
