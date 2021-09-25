package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * author: created by wentaoKing
 * date: created in 2021/9/25
 * description: 958.二叉树的完全性检验
 */
class IsCompleteTree {

    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            if (root == null) return true;
            Deque<TreeNode> deque = new LinkedList<>();
            TreeNode pre = root;
            deque.offer(root);
            while (!deque.isEmpty()) {
                TreeNode node = deque.poll();
                // note: 关键判断，当前节点不为空，前面一个节点为空则不符合
                if (pre == null && node != null) {
                    return false;
                }
                if (node != null) {
                    deque.offer(node.left);
                    deque.offer(node.right);
                }
                pre = node;
            }
            return true;
        }
    }

}
