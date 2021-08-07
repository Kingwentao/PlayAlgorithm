package com.wtk.playalgorithm.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 8/7/21
 * description: 47.全排列II
 */
class PermuteUnique {

    public static void main(String[] args) { }

    static class Solution {

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            int len = nums.length;
            if (len <= 0) return ret;
            Arrays.sort(nums);
            Deque<Integer> paths = new ArrayDeque<>();
            boolean[] used = new boolean[nums.length];
            dfs(nums, 0, nums.length, used,ret, paths);
            return ret;
        }

        private void dfs(int[] nums, int depth, int len, boolean[] used,
                         List<List<Integer>> ret, Deque<Integer> paths){

            if (depth == len) ret.add(new ArrayList<>(paths));
            for (int i = 0; i < len; i++){
                if (used[i]) continue;
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                paths.addLast(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, len, used, ret, paths);
                //回溯
                paths.removeLast();
                used[i] = false;
            }
        }

    }

}
