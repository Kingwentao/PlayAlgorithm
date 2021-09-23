package com.wtk.playalgorithm.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * author: created by wentaoKing
 * date: created in 2021/9/23
 * description: 32.最长有效括号
 */
class LongestValidParentheses {

    public static void main(String[] args) {
    }

    static class Solution {

        // 技巧性解法
        public int longestValidParentheses(String s) {
            int len = s.length();
            int max = 0;
            // ArrayDeque作为栈使用比Stack性能好
            Deque<Integer> stack = new ArrayDeque<>();
            // note: 技巧1，使用额外的一个元素（初始为-1），作为计算长度的起始点
            stack.push(-1);
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        max = Math.max(max, i - stack.peek());
                    } else {
                        stack.push(i);
                    }
                }
            }
            return max;
        }
    }

}
