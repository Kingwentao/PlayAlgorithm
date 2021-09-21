package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 8/13/21
 * description: 5.最长回文子串
 */
class LongestPalindrome {

    public static void main(String[] args) {
        //  String s = "abcddcba";
        String s = "cbbd";
        String res = new Solution().longestPalindrome(s);
        System.out.println(res);

    }

    static class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (s.length() <= 1) return s;
            boolean[][] dp = new boolean[len][len];
            int start = 0;
            int end = 0;
            int maxLen = 1;
            // note: 细节。第一层是右指针，第二个字符开始
            for (int r = 1; r < len; r++) {
                for (int l = 0; l < r; l++) {
                    //note： 关键是这里判断，左右边界的两个字符相等 && （两个数内或者三个数以上时靠中间的数要相等）
                    if (s.charAt(l) == s.charAt(r) && (dp[l + 1][r - 1] || r - l <= 2)) {
                        dp[l][r] = true;
                        if (r - l + 1 > maxLen) {
                            maxLen = r - l + 1;
                            start = l;
                            end = r;
                        }
                    }
                }
            }
            return s.substring(start, end + 1);
        }
    }

}
