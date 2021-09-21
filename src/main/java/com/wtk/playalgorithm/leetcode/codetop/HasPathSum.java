package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;

/**
 * author: created by wentaoKing
 * date: created in 8/12/21
 * description: 112.路径总和
 */
class HasPathSum {

    public static void main(String[] args) {
    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            targetSum -= root.val;
            if (root.left == null && root.right == null) return targetSum == 0;
            return hasPathSum(root.left, targetSum)
                    || hasPathSum(root.right, targetSum);
        }
    }

}
