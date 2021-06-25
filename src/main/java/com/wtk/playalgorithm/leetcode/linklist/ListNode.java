package com.wtk.playalgorithm.leetcode.linklist;

/**
 * author: created by wentaoKing
 * date: created in 4/7/21
 * description:
 */
public class ListNode {
    int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
