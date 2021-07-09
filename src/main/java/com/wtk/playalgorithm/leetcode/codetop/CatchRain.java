package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 7/9/21
 * description: 42.接雨水
 */
class CatchRain {

    public static void main(String[] args) {
        // int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4, 2, 0, 3, 2, 5};
        int ret = trap(height);
        System.out.println("ret: " + ret);
    }

    public static int trap(int[] height) {
        int len = height.length;
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            //找到当前列左边的最高
            int left_max = 0;
            for (int j = i - 1; j >= 0; j--) {
                left_max = Math.max(left_max, height[j]);
            }
            //找到当前列右边的最高
            int right_max = 0;
            for (int j = i + 1; j < len; j++) {
                right_max = Math.max(right_max, height[j]);
            }
            //木桶效应：寻找左右列的最低，以此为基准计数可承载的水
            int min = Math.min(left_max, right_max);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

}
