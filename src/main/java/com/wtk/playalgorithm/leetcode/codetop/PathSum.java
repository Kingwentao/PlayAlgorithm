package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 7/24/21
 * description: 113.路径总和II
 */
class PathSum {

    public static void main(String[] args) {
    }

    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ret = new ArrayList();
            if (root == null) return ret;
            Deque<Integer> path = new ArrayDeque();
            dfs(root, targetSum, ret, path);
            return ret;
        }

        //回溯法处理
        private void dfs(TreeNode root, int targetSum, List<List<Integer>> ret, Deque<Integer> path) {
            targetSum -= root.val;
            path.addLast(root.val);
            if (root.left == null && root.right == null && targetSum == 0) {
                ret.add(new ArrayList<>(path));
            }
            if (root.left != null) {
                dfs(root.left, targetSum, ret, path);
            }
            if (root.right != null) {
                dfs(root.right, targetSum, ret, path);
            }
            path.removeLast();
        }

    }
}
