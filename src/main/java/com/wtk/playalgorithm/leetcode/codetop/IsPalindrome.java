package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 8/31/21
 * description: 234.回文链表
 */
class IsPalindrome {

    public static void main(String[] args) {

    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;
            ListNode fast = head.next;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode head2 = slow.next;
            slow.next = null;
            head2 = reverseList(head2);
            while (head != null && head2 != null) {
                if (head.val != head2.val) return false;
                head = head.next;
                head2 = head2.next;
            }
            return true;
        }

        private ListNode reverseList(ListNode head) {
            ListNode pre = head;
            ListNode cur = null;
            while (pre != null) {
                ListNode node = pre.next;
                pre.next = cur;
                cur = pre;
                pre = node;
            }
            return cur;
        }
    }

}
