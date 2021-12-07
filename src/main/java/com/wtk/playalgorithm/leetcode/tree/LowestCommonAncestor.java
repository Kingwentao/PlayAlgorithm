package com.wtk.playalgorithm.leetcode.tree;

/**
 * author: created by wentaoKing
 * date: created in 5/2/21
 * description: 236.二叉树的最近公共祖先
 * <p>
 * 最近公共祖先的定义：
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
 */
class LowestCommonAncestor {

    public static void main(String[] args) {
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 如果head是p/q中的一个，那说明p/q就是公共祖先，即head是公共祖先
            if (root == null || root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // p、q在root的左右两侧，root就是它们的最近公共祖先
            if (left != null && right != null) return root;
            // left不为空，right为空，说明left就是公共祖先，反之则为right
            return left != null ? left : right;
        }
    }

}
