package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;

/**
 * author: created by wentaoKing
 * date: created in 2021/10/13
 * description: 剑指Offer54:二叉搜索树的第k大节点
 */
class SearchTreeKthLargest {

    public static void main(String[] args) { }

    static class Solution {
        // note：数量会变化，所以不能直接用k，需要定义一个变量
        int count = 0;
        int res;

        public int kthLargest(TreeNode root, int k) {
            if (root == null) return res;
            count = k;
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            // note: 中序遍历（左、根、右）是从小到大，所以右、根、左就是从大到小排序
            dfs(root.right);
            if (--count == 0) {
                res = root.val;
                return;
            }
            dfs(root.left);
        }

    }
}
