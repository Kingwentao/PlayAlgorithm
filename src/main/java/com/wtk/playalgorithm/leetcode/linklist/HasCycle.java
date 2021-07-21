package com.wtk.playalgorithm.leetcode.linklist;

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
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }

}
