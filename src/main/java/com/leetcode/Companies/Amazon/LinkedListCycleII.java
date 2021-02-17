package com.leetcode.Companies.Amazon;

import com.leetcode.top75.LinkedLists.ListNode;

public class LinkedListCycleII {

    public ListNode getIntersection(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return fast;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = getIntersection(head);

        if (slow == null) return null;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
