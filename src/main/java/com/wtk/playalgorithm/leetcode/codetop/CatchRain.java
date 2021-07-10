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
        int ret = trap3(height);
        System.out.println("ret: " + ret);
    }

    //动态规划：先规划出每一列的左右最高值，然后根据木桶效应，计算每一列可以容纳的水
    public static int trap(int[] height) {
        int len = height.length;
        int[] left_max = new int[len];
        int[] right_max = new int[len];

        //记录所有列左边的最高
        for (int i = 1; i <= len - 1; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i - 1]);
        }
        //记录所有列右边的最高
        for (int i = len - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i + 1]);
        }

        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            //木桶效应：寻找当前列的左右最低，以此为基准计算当前列可承载的水
            int min = Math.min(left_max[i], right_max[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    //对动态规划法的空间优化
    public static int trap3(int[] height) {
        int len = height.length;
        int[] right_max = new int[len];
        //可以省下动态规划下中左最大列的数组，直接使用一个变量，在统计和的时候同时去计算
        int left_max = 0;

        //记录所有列右边的最高
        for (int i = len - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i + 1]);
        }

        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            //木桶效应：寻找当前列的左右最低，以此为基准计算当前列可承载的水
            left_max = Math.max(left_max, height[i - 1]);
            int min = Math.min(left_max, right_max[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    //暴力法：按列求的双循环法
    public static int trap2(int[] height) {
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
