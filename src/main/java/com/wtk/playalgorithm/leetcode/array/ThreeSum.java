package com.wtk.playalgorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 3/30/21
 * description: 三数求和: https://leetcode-cn.com/problems/3sum/
 * <p>
 * 核心思想：排序+双指针
 * <p>
 * 思路：
 * 1.特判，对于数组长度 n，如果数组为 null或者数组长度小于 3，返回 []。
 * 2.对数组进行排序。
 * 3.遍历排序后数组：
 * - 若 nums[i]> 0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。对于重复元素：跳过，避免出现重复解
 * 令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行循环：当 nums[i]+nums[L]+nums[R]== 0 ，执行循环，
 * 判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
 * - 若和大于 0，说明 nums[R]太大，RR 左移
 * - 若和小于 0，说明 nums[L] 太小，LL 右移
 */
class ThreeSum {

    public static void main(String[] args) {
        // int nums[] = {-1, 0, 1, 2, -1, -4};
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        System.out.printf("res:" + res.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return result;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> three = new ArrayList<>();
                    three.add(nums[i]);
                    three.add(nums[l]);
                    three.add(nums[r]);
                    result.add(three);
                    while (l < r && nums[l] == nums[l + 1]) ++l;
                    while (l < r && nums[r] == nums[r - 1]) --r;
                    ++l;
                    --r;
                } else if (sum > 0) {
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return result;
    }

}
