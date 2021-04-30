package com.wtk.playalgorithm.leetcode.linklist;

import java.util.Stack;

/**
 * author: WentaoKing
 * created on: 4/30/21
 * description: 剑指Offer-06: 从尾到头打印链表
 * <p>
 * 核心思路：借助栈存储输出
 */
class ReversePrint {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = LinkListUtil.generateLinkList(arr);
        int[] res = reversePrint(head);
        for (int i = 0; i < res.length; i++) {
            System.out.println("res: " + res[i]);
        }
    }

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

}
