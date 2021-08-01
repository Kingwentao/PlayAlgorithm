package com.wtk.playalgorithm.leetcode.codetop;

import java.util.Arrays;

/**
 * author: created by wentaoKing
 * date: created in 8/1/21
 * description: 300.最长递增子序列
 */
class LengthOfLIS {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 21, 18};
        int ret = new Solution().lengthOfLIS(nums);
        System.out.println("ret: " + ret);
    }

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            if (len <= 1) return len;
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            int max = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }

}
