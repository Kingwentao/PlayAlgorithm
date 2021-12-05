package com.wtk.playalgorithm.leetcode.tree;

import java.util.Stack;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/5
 * description: 98.验证二叉搜索树
 * 核心：弄懂中序遍历过程
 */
class Solution {

    long preValue = Long.MIN_VALUE;

    // 递归方式
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean isLefBST = isValidBST(root.left);
        if (!isLefBST) return false;
        if (preValue >= root.val) return false;
        preValue = root.val;
        return isValidBST(root.right);
    }

    // 非递归方式
    public boolean isValidBST2(TreeNode root) {
        long preValue = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (preValue >= root.val) return false;
                preValue = root.val;
                root = root.right;
            }
        }
        return true;
    }

}
