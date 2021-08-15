package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 7/4/21
 * description: 121.买卖股票的最佳时机
 */
class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("max profit: " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的最大现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的最大现金数
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1]);
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }
        return dp[len - 1][0];
    }

}
