package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 2021/11/7
 * description: 678.有效的括号字符串
 */
class CheckValidString {

    public static void main(String[] args) { }

    static class Solution {
        public boolean checkValidString(String s) {
            // 未匹配的左括号数量可能的最小值和最大值
            int min = 0, max = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    min++;
                    max++;
                } else if (c == ')') {
                    min = Math.max(min - 1, 0);
                    max--;
                    if(max < 0) return false;
                } else {
                    // 如果为*：*如果是( , l++,r++
                    // * 如果是）， l--, r--
                    // * 如果不变，l, r不发生变化
                    max++;
                    min = Math.max(min - 1, 0);
                }
            }
            return min == 0;
        }
    }

}
