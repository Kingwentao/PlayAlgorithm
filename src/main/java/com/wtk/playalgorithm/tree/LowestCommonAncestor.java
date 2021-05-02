package com.wtk.playalgorithm.tree;

/**
 * author: created by wentaoKing
 * date: created in 5/2/21
 * description: 寻找二叉树的最近公共祖先
 * <p>
 * 最近公共祖先的定义：
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
 */
class LowestCommonAncestor {

    public static void main(String[] args) {
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //1.left、right都为空==》root的左右子树都不包含p、q
        if (left == null && right == null) return null;
        //2.left为空、right不为空 =》p、q都不在root的左子数上（分两种情况；都在右子树和其中一个在右子树）
        if (left == null) return right;
        //3.left不为空、right为空 =》p、q都不在root的右子数上（分两种情况；都在左子树和其中一个在左子树）
        if (right == null) return left;
        //4.left、right都不为空 ==》 p、q在root的左右两侧，root就是它们的最近公共祖先
        return root;
    }

}
