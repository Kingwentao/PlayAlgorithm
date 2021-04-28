package com.wtk.playalgorithm.leetcode.string;

/**
 * author: created by wentaoKing
 * date: created in 4/18/21
 * description: 两个数字字符串/两超大数字相加：给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和
 * 核心思想：双指针+计算进位
 */
class AddString {

    public static void main(String[] args) {
        String res = addStrings("123456789", "987654321");
        System.out.println("add string result: " + res);
    }

    public static String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            //note: 这里需要减去0字符，才能得到正确结果
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            System.out.printf("n1: " + n1);
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int s = n1 + n2 + carry;
            carry = s / 10;
            sb.append(s % 10);
            --i;
            --j;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }

}
