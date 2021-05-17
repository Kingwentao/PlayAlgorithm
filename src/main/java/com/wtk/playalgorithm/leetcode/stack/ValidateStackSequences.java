package com.wtk.playalgorithm.leetcode.stack;

import java.util.Stack;

/**
 * author: WentaoKing
 * created on: 5/17/21
 * description: 剑指Offer-31：栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * <p>
 * 核心思路：借助一个辅助栈，当栈顶和序列相同，即可弹出。
 */
class ValidateStackSequences {

    public static void main(String[] args) {
        int[] push = new int[]{1, 2, 3, 4, 5};
        int[] pop = new int[]{5, 4, 3, 2, 1};
        boolean ret = validateStackSequences(push, pop);
        System.out.println("ret: " + ret);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        //note：可通过判断栈是否为空
        return stack.isEmpty();
    }

}
