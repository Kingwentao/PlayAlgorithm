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

    // dfs
    static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            if (len == 0) return res;
            used = new boolean[len];
            dfs(nums, 0, len);
            return res;
        }

        private void dfs(int[] nums, int depth, int len) {
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
                dfs(nums, depth + 1, len);
                used[i] = false;
                path.removeLast();
                System.out.println("递归后（回溯）" + path);
            }
        }

    }

}
