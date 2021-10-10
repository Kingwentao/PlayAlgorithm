package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 2021/10/10
 * description: 8.字符串转换整数 (atoi)
 */
class MyAtoi {

    public static void main(String[] args) {
        String str = "2147483646";
        String str2 = "21474";
        int res = new Solution().myAtoi(str);
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    static class Solution {
        public int myAtoi(String s) {
            // 1.去掉多余的空格
            char[] chars = s.toCharArray();
            int index = 0;
            int len = s.length();
            for (Character c : chars) {
                if (c == ' ') index++;
                else break;
            }
            // note:处理全是空格的特殊情况
            if (index == len) {
                return 0;
            }
            // 2.处理正负号
            int sign = 1;
            char fChar = chars[index];
            if (fChar == '+') {
                index++;
            } else if (fChar == '-') {
                index++;
                sign = -1;
            }
            // 3.转换成int（时刻注意边界: 0-9 & MIN-MAX之间）
            int res = 0;
            while (index < len) {
                char c = chars[index];
                // note: 不合法的字符，0-9之外
                if (c < '0' || c > '9') {
                    break;
                }
                if (res > Integer.MAX_VALUE / 10
                        || (res == Integer.MAX_VALUE / 10) && (c - '0') > Integer.MAX_VALUE % 10) {
                    return Integer.MAX_VALUE;
                }
                // note: 注意字符要取反比较： (c - '0') > -(Integer.MIN_VALUE % 10)
                if (res < Integer.MIN_VALUE / 10 ||
                        (res == Integer.MIN_VALUE / 10) && (c - '0') > -(Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + sign * (c - '0');
                index++;
            }
            return res;
        }
    }

}
