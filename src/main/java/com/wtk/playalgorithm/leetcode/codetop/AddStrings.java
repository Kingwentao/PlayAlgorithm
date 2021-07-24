package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 7/11/21
 * description: 415.字符串相加
 */
class AddStrings {

    public static void main(String[] args) {
        Solution s = new Solution();
        String ret = s.addStrings("1123", "977");
        System.out.println("add string sum: " + ret);
    }

    static class Solution {

        public String addStrings(String num1, String num2) {
            if (num1.isEmpty()) return num2;
            if (num2.isEmpty()) return num1;
            int len1 = num1.length();
            int len2 = num2.length();
            StringBuilder sb = new StringBuilder();
            int s = 0;
            int carry = 0;
            while (len1 > 0 || len2 > 0) {
                int n1 = len1 > 0 ? num1.charAt(len1 - 1) - '0' : 0;
                int n2 = len2 > 0 ? num2.charAt(len2 - 1) - '0' : 0;
                s = n1 + n2 + carry;
                sb.append(s % 10);
                carry = s / 10;
                --len1;
                --len2;
            }
            if (s >= 10) sb.append(carry);
            return sb.reverse().toString();
        }

    }
}

