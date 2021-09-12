package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.LinkListUtil;
import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 8/3/21
 * description: 143.重排链表
 */
class ReorderList {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        ListNode head = LinkListUtil.generateLinkList(array);
        new Solution().reorderList(head);
        LinkListUtil.printLink(head);
    }

    static class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;
            ListNode fast = head;
            ListNode slow = head;
            // 使用快慢指针，找到中点，分割成两部分
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 第二段头
            ListNode newHead = slow.next;
            slow.next = null;
            // 反转第二段
            newHead = reverseList(newHead);
            // 重新连接两部分：对后半部分取出元素，记录、连接
            while (newHead != null){
                // 这里先处理后半部分的后续部分，保证next指针，防止断开
                ListNode node = newHead.next;
                newHead.next = head.next;
                head.next = newHead;
                head = newHead.next;
                newHead = node;
            }
        }

        private ListNode reverseList(ListNode head){
            ListNode pre = head;
            ListNode cur = null;
            while (pre != null){
                ListNode node = pre.next;
                pre.next = cur;
                cur = pre;
                pre = node;
            }
            return cur;
        }
    }

}
