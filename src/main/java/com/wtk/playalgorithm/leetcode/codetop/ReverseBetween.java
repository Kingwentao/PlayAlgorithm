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
            // note: 使用一个假的头节点，可以避免单独考虑反转的结点包含头解决的情况
            ListNode cur = dummyHead;
            ListNode pre = dummyHead.next;
            for (int i = 1; i < left; i++) {
                cur = cur.next;
                pre = pre.next;
            }
            // note: 巧妙使用头插法，这里是精髓
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
