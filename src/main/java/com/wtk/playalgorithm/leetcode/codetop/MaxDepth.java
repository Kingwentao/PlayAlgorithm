package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;

/**
 * author: created by wentaoKing
 * date: created in 2021/11/10
 * description: 104.二叉树的最大深度
 */
class MaxDepth {

    public static void main(String[] args) { }

    class Solution {
        public int maxDepth(TreeNode root) {
            int max = 0;
            if(root == null){
                return max;
            } else{
                int l = maxDepth(root.left);
                int r = maxDepth(root.right);
                max = Math.max(l, r) + 1;
            }
            return max;
        }
    }
}
