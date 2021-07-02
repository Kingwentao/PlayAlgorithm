package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;
import com.wtk.playalgorithm.leetcode.tree.TreeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 7/2/21
 * description: 103.二叉树的锯齿形层序遍历
 */
class ZigzagLevelOrder {

    public static void main(String[] args) {
        int[] arr = {3, 9, 20, 0, 0, 15, 7};
        TreeNode root = TreeUtil.generateCompleteTree(arr, 0);
        System.out.println("source tree:" + TreeUtil.printFromTopToBottom(root));
        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println("zigzagLevelOrder result: " + result);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        boolean isLeftToRight = true;
        Deque<TreeNode> treeList = new LinkedList<>();
        treeList.offer(root);
        while (!treeList.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int n = treeList.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = treeList.poll();
                level.add(node.val);
                if (node.left != null) {
                    treeList.offer(node.left);
                }
                if (node.right != null) {
                    treeList.offer(node.right);
                }
            }
            if (!isLeftToRight) {
                Collections.reverse(level);
            }
            ret.add(level);
            isLeftToRight = !isLeftToRight;
        }
        return ret;
    }

}

