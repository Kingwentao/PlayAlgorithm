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

        List<List<Integer>> ret = new ArrayList();
        Deque<Integer> path = new ArrayDeque();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) return ret;
            dfs(root, targetSum);
            return ret;
        }

        //回溯法处理
        private void dfs(TreeNode root, int targetSum) {
            targetSum -= root.val;
            path.addLast(root.val);
            if (root.left == null && root.right == null && targetSum == 0) {
                ret.add(new ArrayList<>(path));
                //note: 这里不需要return，加上结果会错误
            }
            if (root.left != null) {
                dfs(root.left, targetSum);
            }
            if (root.right != null) {
                dfs(root.right, targetSum);
            }
            path.removeLast();
        }
    }

}
