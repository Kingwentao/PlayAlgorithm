package com.wtk.playalgorithm.leetcode.tree;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/5
 * description: 110.平衡二叉树
 */
class IsBalancedTree {

    // 解法1：树型DP（树型动态规划）的套路写法
    class Solution {

        class ReturnData {
            int height;
            boolean isBalanced;

            ReturnData(int height, boolean isBalanced) {
                this.height = height;
                this.isBalanced = isBalanced;
            }
        }

        public boolean isBalanced(TreeNode root) {
            return getReturnData(root).isBalanced;
        }

        public ReturnData getReturnData(TreeNode node) {
            if (node == null) return new ReturnData(0, true);
            ReturnData leftData = getReturnData(node.left);
            ReturnData rightData = getReturnData(node.right);
            boolean isBalance = false;
            int height = Math.max(leftData.height, rightData.height) + 1;
            if (leftData.isBalanced && rightData.isBalanced
                    && Math.abs(leftData.height - rightData.height) < 2) {
                isBalance = true;
            }
            return new ReturnData(height, isBalance);
        }
    }

    // 解法二：简洁递归，从顶至底的暴力法，判断所有子树是否平衡
    class Solution2 {
        public boolean isBalanced(TreeNode root) {
            if(root == null) return true;
            return Math.abs(depth(root.left) - depth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int depth(TreeNode root) {
            if(root == null) return 0;
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }


}
