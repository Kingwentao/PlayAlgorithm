package com.wtk.playalgorithm.leetcode.linklist;

/**
 * author: created by wentaoKing
 * date: created in 2021/11/28
 * description: 两个单链表(可成环)的相交问题，返回相交的第一个节点
 */
class MeetLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode loop1 = getLooperNode(l1);
        ListNode loop2 = getLooperNode(l2);
        ListNode meetNode = null;
        // 两个单链表都没有环
        if (loop1 == null && loop2 == null) {
            meetNode = noLoop(l1, null, l2, null);
        }
        // 两个单链表都是环
        if (loop1 != null && loop2 != null) {
            meetNode = bothLoop(l1, loop1, l2, loop2);
        }
        // 一个有环，一个无环的情况不存在交点
        LinkListUtil.printLink(meetNode);
    }

    // 都是环的情况
    private static ListNode bothLoop(ListNode head1, ListNode loop1,
                                     ListNode head2, ListNode loop2) {
        // 交点在环外，可以转化成无环链表，相交的点就是结束点
        if (loop1 == loop2) {
            return noLoop(head1, loop1, head2, loop2);
        } else {
            // 交点在环内
            ListNode node1 = loop1.next;
            while (node1 != loop1) {
                if (node1 == loop2) return node1;
                node1 = node1.next;
            }
        }
        return null;
    }

    // 无环的情况
    private static ListNode noLoop(ListNode head1, ListNode endNode1, ListNode head2, ListNode endNode2) {
        if (head1 == null || head2 == null) return null;
        // 链表长度差值
        int n = 0;
        ListNode node1 = head1;
        ListNode node2 = head2;
        while (node1.next != endNode1) {
            n++;
            node1 = node1.next;
        }
        while (node2.next != endNode2) {
            n--;
            node2 = node2.next;
        }
        if (node1 != node2) return null;
        // node1 -> 较长的一边
        node1 = n > 0 ? head1 : head2;
        // node2 -> 较短的一边
        node2 = node1 == head1 ? head2 : head1;
        n = Math.abs(n);
        // 较长一条链表先走差值的长度
        while (n > 0) {
            node1 = node1.next;
            n--;
        }
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    private static ListNode getLooperNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        //是否有环
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            // note：fast以两倍速率走。注意先走再比较，因为最开始slow、fast定义的是head
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
