package com.wtk.playalgorithm.leetcode.tree;

/**
 * author: WentaoKing
 * created on: 5/12/21
 * description: 剑指Offer-26: 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * 核心思路：树的遍历 + 递归
 */
class isSubStructure {

    public static void main(String[] args) { }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        //return (A != null && B != null) && (hasSameNode(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        if (A == null || B == null) return false;
        if (hasSameNode(A, B)) {
            return true;
        } else {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    public static boolean hasSameNode(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return hasSameNode(A.left, B.left) && hasSameNode(A.right, B.right);
    }

}
