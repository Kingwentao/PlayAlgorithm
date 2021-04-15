package com.wtk.playalgorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * author: created by wentaoKing
 * date: created in 4/15/21
 * description: 之字形（锯齿形）打印树
 * 思路：DFS/BFS
 */
class ZigZagLevelOrder {

    public static void main(String[] args) {
        int[] arr = {3, 9, 20, 0, 0, 15, 7};
        TreeNode root = TreeUtil.generateTree(arr, 0);
        System.out.println("source tree:" + TreeUtil.printFromTopToBottom(root));
        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println("zigzagLevelOrder result: " + result);
    }

    /**
     * 一层层遍历：设置标识位表示从左还是从右打印，遍历完一层就置反，并用一个数组保存这一层的打印结果，
     * 用一个队列保存该层遍历的结果，用做下层打印的根。
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean isLeftToRight = true;
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        //创建队列，保存节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (isLeftToRight) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }
            result.add(level);
            isLeftToRight = !isLeftToRight;
        }
        return result;
    }

}
