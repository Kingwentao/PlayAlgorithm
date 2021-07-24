package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 7/24/21
 * description: 113.路径总和 II
 */
class PathSum {

    public static void main(String[] args) { }

    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ret = new ArrayList<>();
            Deque<Integer> deque = new LinkedList<>();
            dfs(root,targetSum,ret,deque);
            return ret;
        }

        private void dfs(TreeNode root, int targetSum,
                                        List<List<Integer>> ret, Deque<Integer> deque) {

            if (root == null) return;
            deque.offerLast(root.val);
            targetSum -= root.val;
            if (root.left == null && root.right == null && targetSum == 0){
                ret.add(new LinkedList<>(deque));
            }
            dfs(root.left, targetSum, ret, deque);
            dfs(root.right, targetSum, ret, deque);
            deque.pollLast();
        }
    }
}
