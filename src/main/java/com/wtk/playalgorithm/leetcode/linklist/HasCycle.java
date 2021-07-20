package com.wtk.playalgorithm.leetcode.linklist;

import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 7/20/21
 * description: 141.环形链表
 */
class HasCycle {

    public static void main(String[] args) { }

    public static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null) {
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                }
                if (slow == fast) {
                    return true;
                }
                slow = slow.next;
            }
            return false;
        }
    }

}
