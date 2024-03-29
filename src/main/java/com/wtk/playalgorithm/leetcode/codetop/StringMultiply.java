package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 2021/10/18
 * description: 43.字符串相乘
 */
class StringMultiply {

    public static void main(String[] args) {
        String res = new Solution().multiply("123", "456");
        System.out.println("multiply res: " + res);
    }

    static class Solution {
        public String multiply(String num1, String num2) {
            if(num1.equals("0") || num2.equals("0")) return "0";
            int len1 = num1.length();
            int len2 = num2.length();
            int[] res = new int[len1 + len2];
            for(int i = len1 - 1; i >= 0; i--){
                int a = num1.charAt(i) - '0';
                for(int j = len2 - 1; j >= 0 ; j--){
                    int b = num2.charAt(j) - '0';
                    int sum = res[i + j + 1] + a * b;
                    res[i + j + 1] = sum % 10;
                    res[i + j] += sum / 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < res.length; i++){
                if(i == 0 && res[i] == 0) continue;
                sb.append(res[i]);
            }
            return sb.toString();
        }
    }
}
