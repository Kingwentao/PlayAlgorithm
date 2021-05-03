package com.wtk.playalgorithm.tree;

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
}
