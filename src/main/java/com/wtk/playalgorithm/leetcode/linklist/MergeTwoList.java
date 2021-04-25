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
        int[] arr1 = {0, 2, 4, 5};
        ListNode head = LinkListUtil.generateLinkList(arr1);
        int[] arr2 = {1, 3, 4, 6};
        ListNode head2 = LinkListUtil.generateLinkList(arr2);
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
