package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 8/13/21
 * description: 70.爬楼梯
 */
class ClimbStairs {

    public static void main(String[] args) {
        int stair = new Solution().climbStairs(3);
        System.out.println(stair);
    }

    static class Solution {
        // 动态规划：动态方程，dp[i] = dp[i-1] + dp[i-2]
        public int climbStairs(int n) {
            if (n < 1) return 1;
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

}
