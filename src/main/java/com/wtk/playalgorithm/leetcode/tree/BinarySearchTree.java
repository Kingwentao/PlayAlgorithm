package com.wtk.playalgorithm.leetcode.tree;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/9
 * description: 二叉搜索树的查找、插入、删除
 */
class BinarySearchTree {

    public static void main(String[] args) { }

    class Solution {

        TreeNode root;

        public TreeNode find(int data) {
            if (root == null) return null;
            TreeNode p = root;
            while (p != null) {
                if (p.val > data) {
                    p = p.left;
                } else if (p.val < data) {
                    p = p.right;
                } else {
                    return p;
                }
            }
            return null;
        }

        public void insert(int data) {
            if (root == null) {
                root = new TreeNode(data);
                return;
            }
            TreeNode p = root;
            while (p != null) {
                if (p.val > data) {
                    if (p.left == null) {
                        p.left = new TreeNode(data);
                    }
                    p = p.left;
                } else {
                    if(p.right == null){
                        p.right = new TreeNode(data);
                    }
                    p = p.right;
                }
            }
        }
    }


}
