package com.wtk.playalgorithm.leetcode.linklist;

/**
 * author: created by wentaoKing
 * date: created in 4/7/21
 * description:
 */
class LinkListUtil {
    static void printLink(ListNode head) {
        ListNode node = head;
        while (node != null) {
            if (node.next != null) {
                System.out.print(node.val + "->");
            } else {
                System.out.print(node.val + "->null");
            }
            node = node.next;
        }
    }
}
