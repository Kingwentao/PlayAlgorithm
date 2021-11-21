package com.wtk.playalgorithm.leetcode.linklist;

/**
 * author: created by wentaoKing
 * date: created in 2021/11/21
 * description: 86.分隔链表
 */
class PartitionList {

    public static void main(String[] args) { }

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(-1);
            ListNode dummy2 = new ListNode(-1);
            // note: 使用两个链表容易保持稳定性
            ListNode p1 = dummy1;
            ListNode p2 = dummy2;
            while (head != null) {
                if (head.val < x) {
                    p1.next = head;
                    p1 = p1.next;
                } else {
                    p2.next = head;
                    p2 = p2.next;
                }
                head = head.next;
            }
            p1.next = dummy2.next;
            p2.next = null;
            return dummy1.next;
        }
    }

}
