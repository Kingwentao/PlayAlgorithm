package com.wtk.playalgorithm.leetcode.linklist;

/**
 * author: created by wentaoKing
 * date: created in 4/11/21
 * description: K 个一组翻转链表
 * 思路：递归+反转
 */
class ReverseKGroupList {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5};
        ListNode head = LinkListUtil.generateLinkList(array);
        LinkListUtil.printLink(head);
        ListNode res = reverseKGroup(head, 2);
        System.out.println("\nreverse K group result:");
        LinkListUtil.printLink(res);
    }

    /**
     * 递归：划分成多个k元素反转的子问题
     * note：确定好每次反转后元素head、tail很关键
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //递归退出条件：不够k个结点退出
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        //反转k个元素
        ListNode newHead = reverseList(head, tail);
        //下一轮的开始的地方就是tail
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

}
