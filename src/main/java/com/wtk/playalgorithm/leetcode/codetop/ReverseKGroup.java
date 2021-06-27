package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.LinkListUtil;
import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 6/27/21
 * description: 25.K个一组翻转链表
 */
class ReverseKGroup {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = LinkListUtil.generateLinkList(array);
        LinkListUtil.printLink(head);
        ListNode res = reverseKGroup(head, 2);
        System.out.println("\nreverse K group result:");
        LinkListUtil.printLink(res);
    }

    /**
     * 写法简单的递归思路
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        //这行代码的tail类似单链表反转下的null结点
        ListNode newHead = reverseList(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    public static ListNode reverseList(ListNode head, ListNode tail) {
        ListNode cur = null;
        while (head != tail) {
            ListNode node = head.next;
            head.next = cur;
            cur = head;
            head = node;
        }
        return cur;
    }

    /**
     * 便于理解整个细节过程的循环方法
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            //next：用来存储下一组翻转链表的头结点
            ListNode next = end.next;
            end.next = null;
            //start：当前翻转链表的头
            ListNode start = pre.next;
            //上一组的头（翻转后的尾部）连接当组翻转后的头
            pre.next = reverseList2(start);
            // 重置pre、end，到下一组翻转的头节点的前一节点
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public static ListNode reverseList2(ListNode head) {
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
