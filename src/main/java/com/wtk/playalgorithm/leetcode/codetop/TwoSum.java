package com.wtk.playalgorithm.leetcode.codetop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * author: created by wentaoKing
 * date: created in 7/8/21
 * description: 1.两数之和
 */
class TwoSum {

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
//        int[] num = {3,2,4};
        int[] res = twoSum(num, 9);
        System.out.println("two num is: " + res[0] + " and " + res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] ret = new int[2];
        if (len < 2) return ret;
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int t = target - nums[i];
            if (record.containsKey(t)) {
                ret[0] = record.get(t);
                ret[1] = i;
                break;
            } else {
                record.put(nums[i], i);
            }
        }
        return ret;
    }

}
