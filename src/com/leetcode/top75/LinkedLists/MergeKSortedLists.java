package com.leetcode.top75.LinkedLists;

// * Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class MergeKSortedLists {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null||lists.length==0)return null;

            return mergeSort(lists,0,lists.length-1);

        }
        private ListNode mergeSort(ListNode[] lists,int start,int end){
            if(start==end)return lists[start];
            int mid = start+(end-start)/2;
            ListNode left = mergeSort(lists,start,mid);
            ListNode right = mergeSort(lists,mid+1,end);
            return merge(left,right);
        }
        private ListNode merge(ListNode l1, ListNode l2){
            ListNode res = new ListNode(-1);
            ListNode head = res;
            while(l1!=null&&l2!=null){
                if(l1.val<l2.val) {
                    head.next = l1;
                    l1=l1.next;
                }
                else {
                    head.next = l2;
                    l2=l2.next;
                }
                head=head.next;
            }
            head.next=l1!=null?l1:l2;

            return res.next;
        }
    }
}
