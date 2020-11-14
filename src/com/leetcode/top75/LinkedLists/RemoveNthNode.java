package com.leetcode.top75.LinkedLists;

public class RemoveNthNode {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = head;
        ListNode prev;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        int target = len - n;

        cur = h;

        int j = 0;
        while (j < len) {
            prev = cur;
            cur = cur.next;
            if (j == target) {
                prev.next = cur.next;
                cur.next = null;
                break;
            }
            j++;
        }
        return h.next;
    }
}
