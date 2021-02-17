package com.leetcode.Companies.Qualcomm;

import com.leetcode.top75.LinkedLists.ListNode;

public class MiddleNode {
    /**
     * we have two pointers: One moves fast and the other moves slow.
     * when fast reached the end of the list, we can safely say that The slow pointer has
     * reached the mid point.
     * if the length of the list is odd then we can return slow otherwise we have to return slow.next
     *
     * @param head head of the List Node
     * @return return the mid point
     */
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
