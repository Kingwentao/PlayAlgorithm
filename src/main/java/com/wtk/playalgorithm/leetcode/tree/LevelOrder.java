package com.wtk.playalgorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * author: created by wentaoKing
 * date: created in 5/4/21
 * description: 二叉树的层序遍历: 逐层地，从左到右访问所有节点
 * <p>
 * 核心思路：队列存储 + 每一层的
 */
class LevelOrder {

    public static void main(String[] args) {
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        //note: 需要判空
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            //note：大小需要提前算出来，不能在循环体里算
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                //note：这里需要判空才可以加入
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(list);
        }
        return result;
    }

}
