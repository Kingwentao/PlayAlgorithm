package com.wtk.playalgorithm.leetcode.linklist;

/**
 * author: created by wentaoKing
 * date: created in 4/10/21
 * description: 相交链表，找到相交的节点
 * note: 相交的节点指的是值和地址都相同
 */
class IntersectionNode {

    public static void main(String[] args) {
//        这种直接生成链表是不可行的，不会存在相交的节点，因为值相同的地址也不相同
//        int[] array1 = {4, 1, 8, 4, 5};
//        int[] array2 = {5, 0, 1, 8, 4, 5};
//        ListNode node1 = LinkListUtil.generateLinkList(array1);
//        ListNode node2 = LinkListUtil.generateLinkList(array2);

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
        ListNode res = getIntersectionNode(head1,head2);
        if (res == null) {
            System.out.println("null");
        } else {
            System.out.println(res.val);
        }
    }

    /**
     * 如果存在相交情况：
     *  定义两个指针, 让两个到达当前链表末尾后的节点指向另一个链表的头部, 最后如果相遇则为交点
     *  两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a != null) {
                a = a.next;
            } else {
                a = headB;
            }
            if (b != null) {
                b = b.next;
            } else {
                b = headA;
            }
        }
        return a;
    }

}
