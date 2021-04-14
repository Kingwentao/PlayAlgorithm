package com.wtk.playalgorithm.leetcode.array;

/**
 * author: created by wentaoKing
 * date: created in 4/14/21
 * description: 最大子序和
 */
class MaxSubArray {

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("贪心算法result:" + maxSubArray(array));

        int[] array2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("动态规划result:" + maxSubArray2(array2));
    }

    /**
     * 贪心算法
     */
    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

    /**
     * 动态规划法
     */
    public static int maxSubArray2(int[] nums) {
        int result = nums[0];
        int dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            result = Math.max(result, dp);
        }
        return result;
    }
}
