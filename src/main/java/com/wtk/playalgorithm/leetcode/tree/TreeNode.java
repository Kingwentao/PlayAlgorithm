package com.wtk.playalgorithm.leetcode.tree;

/**
 * author: created by wentaoKing
 * date: created in 4/15/21
 * description: tree node
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
