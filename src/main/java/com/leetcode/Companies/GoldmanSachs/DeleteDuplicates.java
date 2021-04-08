package com.leetcode.Companies.GoldmanSachs;

import com.leetcode.top75.LinkedLists.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode h = head;

        while (h != null && h.next != null) {
            if (h.val == h.next.val) {
                h.next = h.next.next;
            } else {
                h = h.next;
            }
        }
        return head;
    }
}
