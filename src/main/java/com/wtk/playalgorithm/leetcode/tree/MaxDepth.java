package com.wtk.playalgorithm.leetcode.tree;

/**
 * author: created by wentaoKing
 * date: created in 6/7/21
 * description: 104.二叉树的最大深度
 */
class MaxDepth {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        TreeNode root = TreeUtil.generateCompleteTree(arr, 0);
        System.out.println(TreeUtil.printFromTopToBottom(root));

        int d = maxDepth(root);
        System.out.println("max depth is " + d);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

}
