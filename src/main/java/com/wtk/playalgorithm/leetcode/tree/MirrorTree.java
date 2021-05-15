package com.wtk.playalgorithm.leetcode.tree;

/**
 * author: WentaoKing
 * created on: 5/13/21
 * description: 剑指Offer-27: 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/solution/mian-shi-ti-27-er-cha-shu-de-jing-xiang-di-gui-fu-/
 */
class MirrorTree {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        TreeNode root = TreeUtil.generateCompleteTree(arr, 0);
        System.out.println(TreeUtil.printFromTopToBottom(root));

        TreeNode ret = mirrorTree(root);
        System.out.println(TreeUtil.printFromTopToBottom(ret));
    }

    /**
     * 先序遍历 + 交换
     */
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) mirrorTree(root.left);
        if (root.right != null) mirrorTree(root.right);
        return root;
    }

    /**
     * 较难理解的简便写法
     */
    public static TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

}
