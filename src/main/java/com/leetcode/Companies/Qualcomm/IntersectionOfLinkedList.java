package com.leetcode.Companies.Qualcomm;

import com.leetcode.top75.LinkedLists.ListNode;

public class IntersectionOfLinkedList {
    /**
     * The idea behind this approach is that we have to have equal lengths before comparing the ListNodes
     * so first we get the length of the two nodes and skip a few nodes from the longer node.
     * <p>
     * then we start checking if l1 == l2 until l1 and l2 are not null
     *
     * @param l1 ListNode 1
     * @param l2 ListNode 2
     * @return return the intersection point
     */
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
