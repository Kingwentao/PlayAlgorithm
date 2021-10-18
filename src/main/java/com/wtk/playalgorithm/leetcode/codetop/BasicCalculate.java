package com.wtk.playalgorithm.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * author: created by wentaoKing
 * date: created in 2021/10/16
 * description: 227.基本计算器II
 */
class BasicCalculate {

    public static void main(String[] args) {
        String s = "1+2*3";
        System.out.println(new Solution().calculate(s));
    }

    static Map<Character, Integer> level = new HashMap() {{
        level.put('+', 1);
        level.put('-', 1);
        level.put('*', 2);
        level.put('/', 2);
        level.put('%', 2);
        level.put('^', 3);
    }};


    static class Solution {
        public int calculate(String s) {
            s = s.replaceAll(" ", "");
            char[] cArray = s.toCharArray();
            int len = cArray.length;
            // 存放数字
            Deque<Integer> nums = new ArrayDeque<>();
            nums.addLast(0);
            // 存放操作符
            Deque<Character> ops = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                char c = cArray[i];
                if (c == '(') {
                    ops.addLast(c);
                } else if (c == ')') {
                    while (!ops.isEmpty()) {
                        if (ops.peekLast() == '(') {
                            ops.pollLast();
                            break;
                        } else {
                            calculate(nums, ops);
                        }
                    }
                } else {
                    if (isNumber(c)) {
                        int u = 0;
                        int j = i;
                        // 如果第一个字符是数字，需要将后续是数字的字符拼起来
                        while (j < len && isNumber(cArray[j])) u = u * 10 + cArray[j++] - '0';
                        nums.addLast(u);
                        i = j - 1;
                    } else {
                        if (i > 0 && (cArray[i - 1] == '(' || cArray[i - 1] == '+' || cArray[i - 1] == '-')) {
                            nums.addLast(0);
                        }
                        // 如果栈内有操作符号并且不是（ ， 就可以考虑计算了，根据操作符优先级决定
                        while(!ops.isEmpty() && ops.peekLast() != '('){
                            char prev = ops.peekLast();
                            if(level.get(prev) >= level.get(c)){
                                calculate(nums, ops);
                            } else {
                                break;
                            }
                        }
                        ops.addLast(c);
                    }
                }
            }
            // 剩余没计算玩的继续计算
            while (!ops.isEmpty()) calculate(nums, ops);
            return nums.peekLast();
        }

        private void calculate(Deque<Integer> nums, Deque<Character> ops) {
            if (nums.isEmpty() || nums.size() < 2 || ops.isEmpty()) return;
            int b = nums.pollLast();
            int a = nums.pollLast();
            int op = ops.pollLast();
            int ans = 0;
            if (op == '+') ans = a + b;
            else if (op == '-') ans = a - b;
            else if (op == '*') ans = a * b;
            else if (op == '/') ans = a / b;
            else if (op == '%') ans = a % b;
            else if (op == '^') ans = (int) Math.pow(a, b);
            nums.addLast(ans);
        }

        private boolean isNumber(char c) {
            return Character.isDigit(c);
        }
    }

}
