package com.wtk.playalgorithm.leetcode.stack;

import java.util.Stack;

/**
 * author: WentaoKing
 * created on: 5/15/21
 * description: 剑指Offer-30：包含min函数的栈，实现 O(1) 复杂度的min() 函数
 * <p>
 * 核心思路：使用辅助栈存储最小值
 */

class MinStack {

    static Stack<Integer> stack1;
    static Stack<Integer> stack2;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());   // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());     // --> 返回 0.
        System.out.println(minStack.min());    //   --> 返回 -2.
    }

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        //note: 不能用0
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack1.push(x);
        stack2.push(Math.min(stack2.peek(), x));
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        //note: 使用peek，而不是pop
        return stack2.peek();
    }

}
