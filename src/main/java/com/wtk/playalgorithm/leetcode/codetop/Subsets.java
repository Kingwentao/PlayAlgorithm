package com.wtk.playalgorithm.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 8/10/21
 * description: 78.子集
 */
class Subsets {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ret = new Solution().subsets(arr);
        System.out.println(ret);
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            if (nums.length <= 0) return ret;
            Deque<Integer> deque = new ArrayDeque<>();
            dfs(nums,0,nums.length,deque, ret);
            return ret;
        }

        private void dfs(int[] nums, int start, int length, Deque<Integer> deque, List<List<Integer>> ret) {
            ret.add(new ArrayList<>(deque));
            for (int i = start; i < length; i++){
                deque.addLast(nums[i]);
                System.out.println("开始："  + deque);
                dfs(nums, i + 1, length, deque, ret);
                deque.removeLast();
                System.out.println("回溯："  + deque);
            }
        }
    }
}
