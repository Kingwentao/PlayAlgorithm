package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 8/15/21
 * description: 122.买卖股票的最佳时机II
 */
class MaxProfit2 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = new Solution().maxProfit2(prices);
        System.out.println(maxProfit);
    }

    static class Solution {

        // 贪心算法：每个交易日都交易 = 最后一天 - 第一天的交易
        // 只取收益为正 == 最大化
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) return 0;
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                int profit = prices[i] - prices[i - 1];
                if (profit > 0) maxProfit += profit;
            }
            return maxProfit;
        }


        //动态规划：
        public int maxProfit2(int[] prices) {
            int len = prices.length;
            if (len <= 1) return 0;
            // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的最大现金数
            // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的最大现金数
            int[][] dp = new int[len][2];

            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                //note: 买卖股票的最佳时机I不同的地方就在于可以多次买入，所以用上次的结果计算dp[i - 1][0]
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[len - 1][0];
        }

    }

}
