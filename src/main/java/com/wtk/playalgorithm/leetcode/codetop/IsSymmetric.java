package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * author: created by wentaoKing
 * date: created in 8/1/21
 * description: 101.对称二叉树
 */
class IsSymmetric {

    public static void main(String[] args) {
    }

    //解法1：dfs,递归思路
    static class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return false;
            return dfs(root.left, root.right);
        }

        public boolean dfs(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
    }

    //解法2：bfs,迭代思路
    static class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return false;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root.left);
            deque.offer(root.right);
            while (!deque.isEmpty()){
                TreeNode left = deque.poll();
                TreeNode right = deque.poll();
                if (left == null && right == null) continue;
                if (left == null || right == null) return false;
                if (left.val != right.val) return false;
                // note: 这里的入队顺序很关键
                deque.offer(left.left);
                deque.offer(right.right);
                deque.offer(left.right);
                deque.offer(right.left);
            }
            return true;
        }
    }

}
