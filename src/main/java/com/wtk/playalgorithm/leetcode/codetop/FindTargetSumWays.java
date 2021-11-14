package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 2021/11/14
 * description: 494.目标和
 */
class FindTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int res = new Solution().findTargetSumWays(nums, 3);
        System.out.println("sum way is " + res);
    }

    static class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int len = nums.length;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
            }
            if (Math.abs(target) > Math.abs(sum)) return 0;
            // size: (-sum to sum) + 1(表示0这个中间值)
            int size = sum * 2 + 1;
            // dp[i][j]: 从 0-i元素进行加减得到j的所有情况数
            int[][] dp = new int[len][size];
            dp[0][sum - nums[0]] += 1;
            dp[0][sum + nums[0]] += 1;
            // 动态方程：dp[i][j] = dp[i - 1][j - num[i]] + dp[i - 1][j + nums[i]]
            for (int i = 1; i < len; i++) {
                for (int j = -sum; j <= sum; j++) {
                    // 这里为了下标不越界，下标统一加上sum
                    if (j + nums[i] > sum) {
                        dp[i][j + sum] = dp[i - 1][j - nums[i] + sum];
                    } else if (j - nums[i] < -sum) {
                        dp[i][j + sum] = dp[i - 1][j + nums[i] + sum];
                    } else {
                        dp[i][j + sum] = dp[i - 1][j - nums[i] + sum] + dp[i - 1][j + nums[i] + sum];
                    }
                }
            }
            return dp[len - 1][target + sum];
        }
    }

}
