package com.wtk.playalgorithm.leetcode.stack;

import java.util.Stack;

/**
 * author: created by wentaoKing
 * date: created in 6/13/21
 * description: 有效的括号
 */
class IsValidBrackets {

    public static void main(String[] args) {
        String s = "({)[]}]";
        boolean ret = isValid(s);
        System.out.println("ret is " + ret);
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (c == '{'){
                stack.push('}');
            }else if (c == '('){
                stack.push(')');
            }else if (c == '['){
                stack.push(']');
            }else if (stack.empty() || c != stack.pop()){
                return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }

}
