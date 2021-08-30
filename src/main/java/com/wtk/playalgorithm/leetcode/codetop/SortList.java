package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 8/30/21
 * description: 148.排序链表
 */
class SortList {

    class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null) return head;
            ListNode fast = head.next;
            ListNode slow = head;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode h2 = slow.next;
            slow.next = null;
            // 归
            ListNode s1 = sortList(head);
            ListNode s2 = sortList(h2);
            // 并
            ListNode newHead = new ListNode(0);
            ListNode res = newHead;
            while (s1 != null && s2 != null){
                if(s1.val < s2.val){
                    newHead.next = s1;
                    s1 = s1.next;
                }else {
                    newHead.next = s2;
                    s2 = s2.next;
                }
                newHead = newHead.next;
            }
            newHead.next = s1 != null ? s1 : s2;
            return res.next;
        }
    }
}
