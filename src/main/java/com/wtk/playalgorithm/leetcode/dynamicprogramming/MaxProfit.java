package com.wtk.playalgorithm.leetcode.dynamicprogramming;

/**
 * author: created by wentaoKing
 * date: created in 5/4/21
 * description: 买卖股票的最佳时机I
 * 某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 关键思路：定义好dp[][]的含义，理清规划的思路
 */
class MaxProfit {

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println("max profit: " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        //note：定义很关键，dp[i][j]：下标为i这一天结束的时候，手上持股状态为j时，我们持有的现金数
        // dp[i][0]：第i天不持有股票 & dp[i][1]：第i天持有股票
        int dp[][] = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            //1.第i天不持有股票的两种情况：（1）i-1天持有，i天卖出 （2）i-1天不持有，i天仍不买入
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            //2.第i天持有股票的两种情况： （1）i-1天持有，i天仍持有 （2）i-1天不持有，i天买入
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}
