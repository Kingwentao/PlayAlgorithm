package com.wtk.playalgorithm.leetcode.codetop;

import java.util.Stack;

/**
 * author: created by wentaoKing
 * date: created in 7/20/21
 * description: 232.用栈实现队列
 */
class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public static void main(String[] args) {
    }

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            return Integer.MIN_VALUE;
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            return Integer.MIN_VALUE;
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty()) return true;
        return false;
    }


}
