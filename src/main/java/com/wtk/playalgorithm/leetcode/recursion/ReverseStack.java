package com.wtk.playalgorithm.leetcode.recursion;

import java.util.Stack;

/**
 * author: created by wentaoKing
 * date: created in 2022/3/1
 * description: 使用递归实现反转栈：不使用额外空间
 */
class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int last = new Solution().getStackData(stack);
//        new Solution().reverseStack(stack);
        for (int i = 0; i < stack.size(); i++) {
            System.out.println("i" + stack.pop());
        }
    }

    static class Solution {
        void reverseStack(Stack<Integer> stack) {
            if (stack.isEmpty()) return;
            int i = getStackData(stack);
            reverseStack(stack);
            stack.push(i);
        }

        int getStackData(Stack<Integer> stack) {
            int result = stack.pop();
            System.out.println("result: "+ result);
            if (stack.isEmpty()) {
                return result;
            } else {
                int last = getStackData(stack);
                stack.push(result);
                System.out.println("last: " + last);
                return last;
            }
        }

    }
}
