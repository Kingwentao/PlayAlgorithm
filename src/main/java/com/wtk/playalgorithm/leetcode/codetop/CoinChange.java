package com.wtk.playalgorithm.leetcode.codetop;

import java.util.Arrays;

/**
 * author: created by wentaoKing
 * date: created in 8/15/21
 * description: 322.零钱兑换
 */
class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int coin = new Solution().coinChange(coins, 11);
        System.out.println(coin);
    }

    static class Solution {
        public int coinChange(int[] coins, int amount) {
            if (coins.length <= 0) return -1;
            int[] dp = new int[amount + 1];
            // 硬币最多为amount，所以默认可填充amount+1
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0) {
                        // 有两种可能性： 1.不加入该硬币 2.加入该硬币
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
}
