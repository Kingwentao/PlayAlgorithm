package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 8/28/21
 * description: 剑指Offer22:链表中倒数第k个节点
 */
class GetKthFromEnd {
    static class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null) return null;
            ListNode next = head;
            for (int i = 0; i < k; i++) {
                next = next.next;
            }
            while (next != null) {
                head = head.next;
                next = next.next;
            }
            return head;
        }
    }
}
