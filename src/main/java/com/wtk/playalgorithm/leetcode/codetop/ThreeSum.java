package com.wtk.playalgorithm.leetcode.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 6/29/21
 * description: 15.三数之和
 * 排序+双指针
 */
class ThreeSum {

    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        System.out.printf("res:" + res.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return ret;
        Arrays.sort(nums);
        if (nums[n - 1] < 0) return ret;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return ret;
            //note: 去除重复元素其中关键第一步
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> record = new ArrayList<>();
                    record.add(nums[i]);
                    record.add(nums[l]);
                    record.add(nums[r]);
                    ret.add(record);
                    //note: 去除重复元素其中关键第二步
                    while (l < r && nums[l] == nums[l + 1]) ++l;
                    while (l < r && nums[r] == nums[r - 1]) --r;
                    ++l;
                    --r;
                } else if (sum < 0) {
                    ++l;
                } else {
                    --r;
                }
            }
        }
        return ret;
    }

}
