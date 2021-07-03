package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.LinkListUtil;
import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 7/3/21
 * description: 160.相交链表
 */
class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        head1.next = one;
        one.next = two;
        two.next = three;
        three.next = null;

        ListNode head2 = new ListNode(5);
        ListNode one2 = new ListNode(6);
        head2.next = one2;
        one2.next = two;

        LinkListUtil.printLink(head1);
        System.out.println("");
        LinkListUtil.printLink(head2);
        System.out.println("\nget intersection node:");
        ListNode res = getIntersectionNode(head1, head2);
        if (res == null) {
            System.out.println("null");
        } else {
            System.out.println(res.val);
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) return headB;
        if (headB == null) return headA;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null || nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            if (nodeA == null) {
                nodeA = headB;
            } else {
                nodeA = nodeA.next;
            }
            if (nodeB == null) {
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }
        }
        return null;
    }

}
