package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.LinkListUtil;
import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 7/15/21
 * description: 21.合并两个有序链表
 */
class MergeTwoLists {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {0, 2, 4, 5};
        ListNode l1 = LinkListUtil.generateLinkList(arr1);
        int[] arr2 = {1, 3, 4, 6};
        ListNode l2 = LinkListUtil.generateLinkList(arr2);
        ListNode ret = solution.mergeTwoLists(l1, l2);
        LinkListUtil.printLink(ret);
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val > l2.val) {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            } else {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
        }
    }

}


