package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;

/**
 * author: created by wentaoKing
 * date: created in 7/8/21
 * description: 236.二叉树的最近公共祖先
 */
class LowestCommonAncestor {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null; // root left and right not contain p,q
        if (left == null) return right; // in right
        if (right == null) return left; // in left
        return root; // left != null && right != null;
    }

}
