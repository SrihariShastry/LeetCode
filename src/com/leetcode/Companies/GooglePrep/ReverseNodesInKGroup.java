package com.leetcode.Companies.GooglePrep;

import com.leetcode.top75.LinkedLists.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/solution/
 */
public class ReverseNodesInKGroup {

    public ListNode reverse(ListNode head, int k) {
        ListNode res = null;
        ListNode ptr = head;
        while (k > 0) {
            ListNode temp = ptr.next;
            ptr.next = res;
            res = ptr;
            ptr = temp;
            k--;
        }
        return res;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode res = null;
        ListNode kTail = null;
        ListNode ptr = head;

        while (ptr != null) {
            ptr = head;
            int count = 0;

            while (ptr != null && count < k) {
                count++;
                ptr = ptr.next;
            }

            if (count == k) {
                ListNode newHead = reverse(head, k);

                if (res == null) res = newHead;

                if (kTail != null) kTail.next = newHead;

                kTail = head;
                head = ptr;
            }
        }
        if (kTail != null)
            kTail.next = head;

        return res == null ? head : res;
    }
}
