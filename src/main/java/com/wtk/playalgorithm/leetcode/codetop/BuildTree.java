package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;

/**
 * author: created by wentaoKing
 * date: created in 2021/9/12
 * description: 105.从前序与中序遍历序列构造二叉树
 */
class BuildTree {
    public static void main(String[] args) { }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
           return buildTreeHelper(preorder, 0, preorder.length,
                    inorder, 0 , inorder.length);
        }

        private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end,
                                         int[] inorder, int i_start, int i_end){
            if(p_start == p_end){
                return null;
            }
            int root_val = preorder[p_start];
            TreeNode root = new TreeNode(root_val);
            int i_rootIndex = 0;
            for (int i = i_start; i < i_end; i++){
                if(inorder[i] == root_val){
                    i_rootIndex = i;
                    break;
                }
            }
            int left_num = i_rootIndex - i_start;
            root.left = buildTreeHelper(preorder, p_start + 1, p_start + left_num + 1,
                    inorder, i_start, i_rootIndex);
            root.right = buildTreeHelper(preorder, p_start + left_num + 1, p_end,
                    inorder, i_rootIndex + 1, i_end);
            return root;
        }
    }
}
