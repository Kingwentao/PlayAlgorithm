package com.wtk.playalgorithm.leetcode.codetop;

import java.util.Stack;

/**
 * author: created by wentaoKing
 * date: created in 8/12/21
 * description: 20.有效的括号
 */
class isValidBrackets {

    public static void main(String[] args) {
        String brackets = "()[]{}";
        boolean ret = new Solution().isValid(brackets);
        System.out.println(ret);
    }

    static class Solution {
        public boolean isValid(String s) {
            if (s.length() <= 0) return false;
            Stack<Character> stack = new Stack<>();
            for (Character c : s.toCharArray()) {
                if (c == '[') {
                    stack.push(']');
                } else if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
            if (stack.isEmpty()) return true;
            return false;
        }
    }
}
