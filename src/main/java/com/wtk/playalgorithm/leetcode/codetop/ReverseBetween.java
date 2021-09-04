package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 8/29/21
 * description: 92.反转链表II
 */
class ReverseBetween {

    static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || left <= 0 || left >= right) return head;
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;

            ListNode cur = dummyHead;
            ListNode pre = dummyHead.next;

            for (int i = 0; i < left - 1; i++) {
                cur = cur.next;
                pre = pre.next;
            }

            for (int i = 1; i < right - left + 1; i++) {
                ListNode rm = pre.next;
                pre.next = pre.next.next;

                rm.next = cur.next;
                cur.next = rm;
            }
            return dummyHead.next;
        }

    }

}