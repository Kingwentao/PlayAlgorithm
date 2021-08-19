package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;

/**
 * author: created by wentaoKing
 * date: created in 8/19/21
 * description: 98.验证二叉搜索树
 */
class IsValidBST {

    public static void main(String[] args) {

    }

    static class Solution {
        long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 访问左子树
            if (!isValidBST(root.left)) {
                return false;
            }
            if (root.val <= pre) return false;
            pre = root.val;
            // 访问右子树
            return isValidBST(root.right);
        }
    }

}
