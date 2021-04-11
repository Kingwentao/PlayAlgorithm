package com.wtk.playalgorithm.leetcode.linklist;

/**
 * author: created by wentaoKing
 * date: created in 4/7/21
 * description: 链表工具类
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

    static ListNode generateLinkList(int[] array) {
        ListNode head = new ListNode(array[0]);
        ListNode node = head;
        for (int i = 1; i < array.length; i++) {
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        node.next = null;
        return head;
    }

}
