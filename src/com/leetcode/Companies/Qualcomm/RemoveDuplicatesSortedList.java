package com.leetcode.Companies.Qualcomm;

import com.leetcode.top75.LinkedLists.ListNode;

public class RemoveDuplicatesSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }
        ListNode cur = head;
        while (cur != null && cur.val == head.val) {
            cur = cur.next;
        }
        return deleteDuplicates(cur);
    }
}
