package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;

/**
 * author: created by wentaoKing
 * date: created in 2021/9/12
 * description: 129.求根节点到叶节点数字之和
 */
class SumNumbers {
    public static void main(String[] args) {

    }

    class Solution {
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode root, int sum) {
            if(root == null) return 0;
            sum += sum * 10 + root.val;
            if(root.left == null && root.right == null){
                return sum;
            }
            return dfs(root.left, sum) + dfs(root.right, sum);
        }

    }
}
