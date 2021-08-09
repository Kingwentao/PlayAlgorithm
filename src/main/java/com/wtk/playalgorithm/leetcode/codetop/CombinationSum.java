package com.wtk.playalgorithm.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 8/9/21
 * description: 39.组合总和
 */
class CombinationSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        System.out.println(new Solution().combinationSum(arr, 7));
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int len = candidates.length;
            List<List<Integer>> ret = new ArrayList<>();
            if (len < 1) {
                return ret;
            }
            Deque<Integer> deque = new ArrayDeque<>();
            dfs(candidates, target, 0, len, deque, ret);
            return ret;
        }

        private void dfs(int[] candidates, int target, int begin, int len,
                         Deque<Integer> deque, List<List<Integer>> ret) {
            if (target < 0) return;
            if (target == 0) {
                ret.add(new ArrayList<>(deque));
                return;
            }
            //note: 为什么要用begin？
            for (int i = begin; i < len; i++) {
                deque.addLast(candidates[i]);
                dfs(candidates, target - candidates[i], i, len, deque, ret);
                deque.removeLast();
            }
        }
    }

}
