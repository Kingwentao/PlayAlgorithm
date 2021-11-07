package com.wtk.playalgorithm.leetcode.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 2021/11/7
 * description: 442.数组中重复的数据
 */
class FindDuplicates {
    public static void main(String[] args) {
        // 1 2 3 4 5 2
        // 0 -1 2 3 4
        int[] nums = {1, 2, 3, 4, 5, 2, 3};
        List<Integer> res = new Solution().findDuplicates(nums);
        System.out.println("res: " + res);
    }

    static class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                // 2 -> 1
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] < 0) {
                    // 1 -> 2
                    res.add(Math.abs(index + 1));
                }
                // 2 -> -2
                nums[index] = -nums[index];
            }
            return res;
        }
    }

}
