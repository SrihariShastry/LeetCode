package com.leetcode.top75.Arrays;

public class SearchRotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums,0,nums.length,target);
        }
        private int binarySearch(int[] nums, int start, int end, int target){
            while(start<=end){
                int mid = start+(end-start)/2;

                if(nums[mid]==target)
                    return mid;
                //find if left half is sorted
                if(nums[mid]>=nums[start]){
                    if(target>=nums[start]&&target<=nums[mid])
                        end=mid-1;
                    else
                        start=mid+1;
                }
                else{
                    if(target<=nums[end]&&target>nums[mid])
                        start=mid+1;
                    else
                        end=mid-1;
                }
            }
            return -1;
        }
    }
}
