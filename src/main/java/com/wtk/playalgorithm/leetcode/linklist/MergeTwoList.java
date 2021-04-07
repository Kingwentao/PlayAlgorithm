package com.wtk.playalgorithm.leetcode.linklist;

import static com.wtk.playalgorithm.leetcode.linklist.LinkListUtil.printLink;

/**
 * author: created by wentaoKing
 * date: created in 4/7/21
 * description: 合并两个有序链表
 * 思路：递归
 */
class MergeTwoList {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(5);

        ListNode head2 = new ListNode(1);
        ListNode one2 = new ListNode(3);
        ListNode two2 = new ListNode(4);
        ListNode three2 = new ListNode(6);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = null;

        head2.next = one2;
        one2.next = two2;
        two2.next = three2;
        three2.next = null;
        printLink(mergeTwoLists(head, head2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1.退出条件
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        //2.划分子问题
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

}
