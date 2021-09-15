package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 7/11/21
 * description: 53.最大子序和
 */
class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, 1, 2, -1};
        int ret = new Solution().maxSubArray2(arr);
        System.out.println("ret: " + ret);
    }

    static class Solution {
        // 贪心法
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            if (nums.length <= 0) return max;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                //sum<0则表示，之前的数对当前的值没有增益效果，直接舍弃
                if (sum < 0) {
                    sum = 0;
                }
                sum += nums[i];
                max = Math.max(sum, max);
            }
            return max;
        }

        public int maxSubArray2(int[] nums) {
            int max = Integer.MIN_VALUE;
            if (nums.length <= 0) return 0;
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++){
                if(dp[i - 1] + nums[i] > 0){
                    dp[i] = dp[i - 1] + nums[i];
                }else{
                    dp[i] = nums[i];
                }
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }

}
