package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.LinkListUtil;
import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 6/25/21
 * description: 206.反转链表
 */
class ReverseList {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        ListNode node = LinkListUtil.generateLinkList(array);
        ListNode head = reverseList(node);
        LinkListUtil.printLink(head);
    }

    /**
     * 双指针法
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = null;
        while (pre != null) {
            //note：提前存储反转后要执行的下一个点，否则反转后会断开
            ListNode node = pre.next;
            pre.next = cur;
            cur = pre;
            pre = node;
        }
        return cur;
    }

}
