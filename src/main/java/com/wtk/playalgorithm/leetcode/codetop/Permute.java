package com.wtk.playalgorithm.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 8/4/21
 * description: 46.全排列
 */
class Permute {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            if (len == 0) return res;
            boolean[] used = new boolean[len];
            Deque<Integer> path = new ArrayDeque<>();
            dfs(nums, 0, len, used, path, res);
            return res;
        }

        private void dfs(int[] nums, int depth, int len, boolean[] used,
                         Deque<Integer> path, List<List<Integer>> res) {
            if (depth == len) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (used[i]) continue;
                path.addLast(nums[i]);
                used[i] = true;
                //递归前
                System.out.println("递归" + path);
                dfs(nums, depth + 1, len, used, path, res);
                used[i] = false;
                path.removeLast();
                System.out.println("递归后（回溯）" + path);
            }
        }

    }

}
