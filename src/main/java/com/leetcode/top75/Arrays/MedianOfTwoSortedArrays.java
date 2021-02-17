package com.leetcode.top75.Arrays;

public class MedianOfTwoSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] total = new int[nums1.length+nums2.length];
            int k=0;
            int i=0,j=0;
            while(i<nums1.length&&j<nums2.length){
                if(nums1[i]<=nums2[j]){
                    total[k++]=nums1[i++];
                }else
                    total[k++]=nums2[j++];
            }
            while(i<nums1.length)
                total[k++]=nums1[i++];
            while(j<nums2.length)
                total[k++]=nums2[j++];

            return median(total);
        }
        private double median(int[] nums){
            if(nums.length==0)return 0.0;

            if(nums.length%2==0)
                return (nums[nums.length/2]+nums[(nums.length/2)-1])/2.0;
            else
                return nums[nums.length/2];
        }

    }
}
