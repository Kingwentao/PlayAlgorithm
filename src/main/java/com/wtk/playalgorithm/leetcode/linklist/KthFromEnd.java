package com.wtk.playalgorithm.leetcode.linklist;

/**
 * author: WentaoKing
 * created on: 5/11/21
 * description: 剑指Offer-22: 链表中倒数第k个节点
 * <p>
 * 核心思路： 用步距为k的双指针可代替一次获取链表长度的遍历过程
 */
class KthFromEnd {

    public static void main(String[] args) {
        ListNode head = LinkListUtil.generateLinkList(new int[]{1, 2, 3, 4, 5, 6, 7});
        LinkListUtil.printLink(head);
        ListNode ret = getKthFromEnd(head, 3);
        LinkListUtil.printLink(ret);
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        //设计两个步距为k的指针，当前面的指针到达尾部，后面的指针就是倒数第k个节点的头
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

}
