package com.wtk.playalgorithm.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/5
 * description: 662.二叉树最大宽度（两端点间的null节点也计入长度）
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 */
class WidthOfBinaryTree {

    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            Deque<TreeNode> deque = new LinkedList();
            // 记录每个结点在完全二叉树中的位置点
            LinkedList<Integer> list = new LinkedList();
            deque.offer(root);
            list.add(1);
            int maxWidth = 1;
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    int curIndex = list.remove();
                    if (node.left != null) {
                        deque.offer(node.left);
                        list.add(curIndex * 2);
                    }
                    if (node.right != null) {
                        deque.offer(node.right);
                        list.add(curIndex * 2 + 1);
                    }
                }
                if (list.size() >= 2) {
                    maxWidth = Math.max(list.getLast() - list.getFirst() + 1, maxWidth);
                }
            }
            return maxWidth;
        }
    }
}
