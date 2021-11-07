package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 2021/10/28
 * description: 151.翻转字符串里的单词
 */
class ReverseWord {

    public static void main(String[] args) {
        String s = "www toutiao com";
        System.out.println(new Solution().reverseWords(s));
    }

    static class Solution {
        public String reverseWords(String s) {
            String[] words = s.trim().split(" ");
            StringBuilder sb = new StringBuilder();
            //note: 倒序存储很关键
            for (int i = words.length - 1; i >= 0; i--) {
                // note: 内部的如果是空直接跳过
                if (words[i].isEmpty()) continue;
                sb.append(words[i]);
                if (i != 0) sb.append(" ");
            }
            return sb.toString();
        }
    }
}
