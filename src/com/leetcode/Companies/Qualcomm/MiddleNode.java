package com.leetcode.Companies.Qualcomm;

import com.leetcode.top75.LinkedLists.ListNode;

public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode headLen = head;
        int len = 0;

        while (headLen != null) {
            len++;
            headLen = headLen.next;
        }
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return len % 2 == 0 ? slow.next : slow;

    }
}
