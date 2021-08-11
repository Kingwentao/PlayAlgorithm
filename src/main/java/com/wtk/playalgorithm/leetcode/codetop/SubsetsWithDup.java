package com.wtk.playalgorithm.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 8/11/21
 * description: 90.子集II
 */
class SubsetsWithDup {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> ret = new Solution().subsetsWithDup(arr);
        System.out.println(ret);
    }

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            if (nums.length <= 0) return ret;
            Arrays.sort(nums);
            Deque<Integer> deque = new ArrayDeque<>();
            dfs(nums, 0, nums.length, deque, ret);
            return ret;
        }

        private void dfs(int[] nums, int begin, int length,
                         Deque<Integer> deque, List<List<Integer>> ret) {

            ret.add(new ArrayList<>(deque));
            for (int i = begin; i < length; i++){
                //剪枝
                if (i > begin && nums[i] == nums [i - 1]){
                    System.out.println("i = " + i + " begin = " + begin);
                    continue;
                }
                System.out.println("递归：" + deque);
                deque.addLast(nums[i]);
                dfs(nums, i + 1, length, deque, ret);
                deque.removeLast();
                System.out.println("回溯：" + deque);
            }
        }

    }

}
