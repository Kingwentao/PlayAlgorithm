package com.wtk.playalgorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/1
 * description: 树的三种遍历
 */
class TreeTraversal {

    public static void main(String[] args) { }

    class Solution {

        // 先序遍历（中、左、右）
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            preorder(root, ret);
            return ret;
        }

        void preorder(TreeNode root, List<Integer> ret) {
            if (root == null) return;
            // 1
            // 递归序第1次经过的值
            ret.add(root.val);
            preorder(root.left, ret);
            preorder(root.right, ret);
        }

        // 中序遍历（左、中、右）
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            inorder(root, ret);
            return ret;
        }

        void inorder(TreeNode root, List<Integer> ret){
            if(root == null) return;
            inorder(root.left, ret);
            // 2
            // 2
            // 递归序第二次经过的值
            ret.add(root.val);
            inorder(root.right, ret);
        }

        // 后序遍历（左、右、中）
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            postorder(root, ret);
            return ret;
        }

        void postorder(TreeNode root, List<Integer> ret){
            if(root == null) return;
            postorder(root.left, ret);
            postorder(root.right, ret);
            // 3
            // 3
            // 递归序第三次经过的值
            ret.add(root.val);
        }

    }

}
