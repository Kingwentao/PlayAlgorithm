package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 2021/10/26
 * description: 1143.最长公共子序列
 */
class LongestCommonSubsequence {

    public static void main(String[] args) {
        int res = new Solution().longestCommonSubsequence("abcde", "ace");
        System.out.println("res = " + res);
    }

    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();
            // dp[i][j] ==> 比较[0,i] 和 [0,j] 公共最长子序列
            // dp[0][j] = 0 dp[i][0] = 0
            int[][] dp = new int[len1 + 1][len2 + 1];
            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[len1][len2];
        }
    }

}
