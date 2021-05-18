package com.wtk.playalgorithm.leetcode.tree;

/**
 * author: WentaoKing
 * created on: 5/18/21
 * description: 剑指Offer-33：二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果
 * <p>
 * 核心思路：遍历区间的元素，找到第一个大于根节点（序列最后一个元素），根据该值划分左右子树，
 */
class VerifyPostorder {

    public static void main(String[] args) {
        int[] postorder = new int[]{1, 2, 5, 10, 6, 9, 4, 3};
        boolean ret = verifyPostorder(postorder);
        System.out.println("vertify result: " + ret);
    }

    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public static boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        //note：遍历过程，只要有一个元素不符合大小，就说明不是后续遍历结果，所以根据p==j判断该树是否正确
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

}
