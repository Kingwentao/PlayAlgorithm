package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 8/17/21
 * description: 2.两数相加
 */
class AddTwoNumbers {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            int carry = 0;
            while (l1 != null || l2 != null){
                // 缺位补0
                int x = l1 == null ? 0: l1.val;
                int y = l2 == null ? 0: l2.val;
                int sum = x + y + carry;
                carry = sum / 10;
                sum = sum % 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            if (carry == 1) cur.next = new ListNode(1);
            return pre.next;
        }
    }
}
