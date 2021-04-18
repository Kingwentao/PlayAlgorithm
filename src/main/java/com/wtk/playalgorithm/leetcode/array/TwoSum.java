package com.wtk.playalgorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * author: created by wentaoKing
 * date: created in 4/17/21
 * description: 两数之和
 * 核心：通过hash表存储遍历过的值，在hash表中查找(target-正在遍历的数)
 * 找到则存在这样的两个数
 */
class TwoSum {

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        int[] res = twoSum(num, 9);
        System.out.println("two num is: " + res[0] + "and" + res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        //key: 元素 value：元素对应下标
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(target - nums[i])) {
                return new int[]{record.get(target - nums[i]), i};
            }
            record.put(nums[i], i);
        }
        throw new IllegalArgumentException("not exist the two sum is target");
    }
}
