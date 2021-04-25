package com.wtk.playalgorithm.leetcode.linklist;

import static com.wtk.playalgorithm.leetcode.linklist.LinkListUtil.printLink;

/**
 * author: created by wentaoKing
 * date: created in 4/4/21
 * description: 反转链表
 */
class ReverseList {


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = null;
        printLink(head);
//        System.out.println("\nreverse 1 result: ");
//        printLink(reverseList(head));
//        System.out.println("\nreverse 2 result: ");
//        printLink(reverseList2(head));
        System.out.println("\nreverse 3 result: ");
        printLink(reverseList3(head));
    }

    /**
     * 容易理解双指针法： pre指针先于cur指针，局部翻转
     * 1.定义两个指针： pre 和 cur，pre 在前 cur 在后。
     * 2.每次让 pre的 next 指向 cur，实现一次局部反转
     * 3.局部反转完成之后，pre 和 cur 同时往前移动一个位置
     * 4.循环上述过程，直至 pre 到达链表尾部
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode node = pre.next;
            pre.next = cur;
            cur = pre;
            pre = node;
        }
        return cur;
    }

    /**
     * 妖魔化的双指针，保持head不变，不断更改head的next
     * 1.原链表的头结点就是反转之后链表的尾结点，使用 head 标记
     * 2.定义指针 cur，初始化为 head
     * 3.每次都让 head 下一个结点的 next 指向 cur ，实现一次局部反转
     * 4.局部反转完成之后，cur 和 head 的 next 指针同时 往前移动一个位置
     * 5.循环上述过程，直至 cur 到达链表的最后一个结点
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        if (head == null) return head;
        while (head.next != null) {
            //node用来标记局部反转后，被截断的后半部分链表头
            ListNode node = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = node;
        }
        return cur;
    }

    /**
     * 递归法
     */
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}
