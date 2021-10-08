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
        List<List<Integer>> ret = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int len = candidates.length;
            if (len < 1) {
                return ret;
            }
            dfs(candidates, target, 0, len);
            return ret;
        }

        private void dfs(int[] candidates, int target, int begin, int len) {
            //note: 不做该判断会结果超时
            if (target < 0) return;
            if (target == 0) {
                ret.add(new ArrayList<>(deque));
            }
            // note: 为什么要用begin？
            // 搜索的时候实现去重，[2,2,3] 和 [3,2,2] 是重复的
            // 按照搜索顺序，下一轮递归不再遍历之前的元素，使用begin而不是0作为起始点，就可以解决不再重复遍历之前的数
            for (int i = begin; i < len; i++) {
                deque.addLast(candidates[i]);
                System.out.println("(" + i + ")递归前：" + deque);
                // 注意这里不是begin不是i+1，因为可以重复取同一个元素
                dfs(candidates, target - candidates[i], i, len);
                deque.removeLast();
                System.out.println("(" + i + ")回溯后：" + deque);
            }
        }
    }

}
