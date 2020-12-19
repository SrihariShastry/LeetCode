package com.leetcode.Companies.Qualcomm;

import com.leetcode.top75.LinkedLists.ListNode;

public class IntersectionOfLinkedList {

    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {

        //find the length of the two lists;
        int len1 = 0, len2 = 0;
        ListNode a = l1;
        ListNode b = l2;

        while (a != null) {
            len1++;
            a = a.next;
        }
        while (b != null) {
            len2++;
            b = b.next;
        }
        //check which is greater and make them equal by ignoring the first few nodes of the larger list
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (len1 > len2) {
            p1 = p1.next;
            len1--;
        }
        while (len2 > len1) {
            p2 = p2.next;
            len2--;
        }
        //keep checking where they intersect
        while (p1 != null && p2 != null) {
            if (p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
