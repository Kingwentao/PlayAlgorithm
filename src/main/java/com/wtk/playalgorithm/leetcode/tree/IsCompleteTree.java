package com.wtk.playalgorithm.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * author: created by wentaoKing
 * date: created in 5/3/21
 * description: 判断树是否是完全二叉树
 * <p>
 * 核心思路：层级遍历（借助队列）+ 遍历过程遇到过空节点，并且当前节点不为空，此时不是完全二叉树
 */
class IsCompleteTree {

    public static void main(String[] args) {
    }

    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            //note：层级遍历可借助队列存储下来
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            //定义：层次遍历过程是否遇到空节点
            boolean isMeetNull = false;
            while (!queue.isEmpty()) {
                TreeNode cNode = queue.poll();
                //遍历过程遇到过空节点，并且当前节点不为空，此时不是完全二叉树
                if (isMeetNull && cNode != null) {
                    return false;
                }
                //层次遍历过程遇到空节点，标记下来
                if (cNode == null) {
                    isMeetNull = true;
                    continue;
                }
                queue.offer(cNode.left);
                queue.offer(cNode.right);
            }
            return true;
        }

        // 解法二(from 左程云b站课程)： 左空右不空 || 叶子结点层出现了左/右结点不为空的情况 -> false
        public boolean isCompleteTree2(TreeNode root) {
            if (root == null) return true;
            Deque<TreeNode> deque = new LinkedList();
            deque.offer(root);
            boolean isLeaf = false;
            while (!deque.isEmpty()) {
                TreeNode node = deque.poll();
                TreeNode lNode = node.left;
                TreeNode rNode = node.right;
                // 左空右不空 || 叶子结点层出现了左右结点不为空 -> false
                if (lNode == null && rNode != null || isLeaf && (lNode != null || rNode != null))
                    return false;
                if (lNode != null) deque.offer(lNode);
                if (rNode != null) deque.offer(rNode);
                // 如果出现左右为空的情况，对于完全二叉树来说一定会是叶子结点层
                if (rNode == null || lNode == null) isLeaf = true;
            }
            return true;
        }
    }

}
