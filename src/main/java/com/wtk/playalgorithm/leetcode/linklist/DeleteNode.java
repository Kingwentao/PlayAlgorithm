package com.wtk.playalgorithm.leetcode.linklist;

/**
 * author: created by wentaoKing
 * date: created in 5/11/21
 * description: 剑指 Offer 18. 删除链表的节点
 */
class DeleteNode {

    public static void main(String[] args) {
        ListNode head = LinkListUtil.generateLinkList(new int[]{1,2,3,5,6,7});
        LinkListUtil.printLink(head);
        deleteNode(head,2);
        LinkListUtil.printLink(head);
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode pre = head;
        ListNode cur = head.next;
        //找到要删除结点时的cur和pre
        while (cur != null && cur.val != val){
            pre = cur;
            cur = cur.next;
        }
        //删除结点
        if (cur != null) pre.next = cur.next;
        return head;
    }

}
