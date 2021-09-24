package com.wtk.playalgorithm.leetcode.codetop;

import java.util.Stack;

/**
 * author: created by wentaoKing
 * date: created in 2021/9/24
 * description: 155.最小栈
 */
class MinStack {

    public static void main(String[] args) {

    }

     class Solution {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /** initialize your data structure here. */
        public Solution() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int val) {
            stack1.push(val);
            if(stack2.isEmpty() || stack2.peek() > val){
                stack2.push(val);
            }else{
                stack2.push(stack2.peek());
            }
        }

        public void pop() {
            if(!stack1.isEmpty()){
                stack1.pop();
            }
            if(!stack2.isEmpty()){
                stack2.pop();
            }
        }

        public int top() {
            if(!stack1.isEmpty()){
                return stack1.peek();
            }
            throw new RuntimeException("stack is not allow empty");
        }

        public int getMin() {
            if(!stack2.isEmpty()){
                return stack2.peek();
            }
            throw new RuntimeException("stack is not allow empty");
        }
    }
}
