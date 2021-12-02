package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 8/30/21
 * description: 19.删除链表的倒数第N个结点
 */
class RemoveNthFromEnd {

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null || n < 1) return head;
            //note: dummy假头指针在该题中很关键，可以避免掉去单独处理n=1的情况
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode fast = dummy.next;
            ListNode slow = dummy;
            for(int i = 1; i <= n; i++){
                fast = fast.next;
                // note: 可以加一个判断早点结束n无限大情况（不加也不会出错）
                if(fast == null) break;
            }
            while(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}
