package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.linklist.ListNode;

/**
 * author: created by wentaoKing
 * date: created in 2021/9/21
 * description: 23.合并K个升序链表
 */
class MergeKLists {

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length < 1) return null;
            return mergeLists(lists, 0, lists.length - 1);
        }

        private ListNode mergeLists(ListNode[] lists, int lo, int hi){
            if(lo == hi){
                return lists[lo];
            }
            int mid = lo + (hi - lo) / 2;
            ListNode l1 = mergeLists(lists, lo, mid);
            ListNode l2 = mergeLists(lists, mid + 1, hi);
            return mergeTwoList(l1, l2);
        }

        private ListNode mergeTwoList(ListNode l1, ListNode l2){
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            while(true){
                if(l1.val < l2.val){
                    l1.next = mergeTwoList(l1.next ,l2);
                    return l1;
                }else{
                    l2.next = mergeTwoList(l1, l2.next);
                    return l2;
                }
            }
        }
    }
}
