package com.wtk.playalgorithm.leetcode.string;

/**
 * author: created by wentaoKing
 * date: created in 4/18/21
 * description: 字符串相加
 * 核心思想：双指针+计算进位
 */
class AddString {

    public static void main(String[] args) {
        String res = addStrings("11", "123");
        System.out.println("add string result: " + res);
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        //进位
        int s = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = n1 + n2 + s;
            s = temp / 10;
            result.append(temp % 10);
            i--;
            j--;
        }
        if (s == 1) result.append(1);
        return result.reverse().toString();
    }

}
