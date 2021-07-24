package com.wtk.playalgorithm.leetcode.tree;

/**
 * author: created by wentaoKing
 * date: created in 7/24/21
 * description: 112.路径总和
 */
class HasPathSum {

    public static void main(String[] args) { }

    static class Solution {
        //dfs: 寻找叶子节点
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            if (root.left == null && root.right == null) return targetSum == root.val;
            return hasPathSum(root.left, targetSum - root.val)
                    || hasPathSum(root.right, targetSum - root.val);
        }

    }

}
