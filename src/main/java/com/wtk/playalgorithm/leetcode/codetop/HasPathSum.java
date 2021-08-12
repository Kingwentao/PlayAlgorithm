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
            if (root.left == null && root.right == null) return root.val == targetSum;
            return hasPathSum(root.left, targetSum - root.val)
                    || hasPathSum(root.right, targetSum - root.val);
        }
    }

}
