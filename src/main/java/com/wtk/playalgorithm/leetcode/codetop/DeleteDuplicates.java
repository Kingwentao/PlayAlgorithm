package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 8/31/21
 * description: 82.删除排序链表中的重复元素II
 */
class DeleteDuplicates {

    public static void main(String[] args) {
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;
            if (head.val != head.next.val) {
                head.next = deleteDuplicates(head.next);
                return head;
            } else {
                ListNode move = head.next.next;
                while (move != null && head.val == move.val) {
                    move = move.next;
                }
                return deleteDuplicates(move);
            }
        }
    }

}
