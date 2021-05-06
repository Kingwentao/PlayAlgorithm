package com.wtk.playalgorithm.leetcode.queue;

import java.util.Stack;

/**
 * author: created by wentaoKing
 * date: created in 5/6/21
 * description: 用栈实现队列
 */
class StackQueue {

    //note：两个栈的定义，其中栈1用来入队，栈2用来出队列，放置队头元素
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) { }

    StackQueue(){ }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty()) return true;
        return false;
    }

}
