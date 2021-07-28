package com.wtk.playalgorithm.leetcode.codetop;

import com.wtk.playalgorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * author: created by wentaoKing
 * date: created in 7/28/21
 * description: 199.二叉树的右视图
 */
class RightSideView {

    public static void main(String[] args) { }

    static class Solution {

        List<Integer> res = new ArrayList<>();

        //bfs: 遍历每一层，把该层最后一个节点加入即可
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
               int size = queue.size();
               for (int i = 0; i < size; i++){
                   TreeNode node = queue.poll();
                   if (node != null && node.left != null) queue.offer(node.left);
                   if (node != null && node.right != null) queue.offer(node.right);
                   if (i == size - 1){
                       res.add(node.val);
                   }
               }
            }
            return res;
        }

        public List<Integer> rightSideView2(TreeNode root) {
            dfs(root, 0);
            return res;
        }

        //按照 根结点 -> 右子树 -> 左子树的顺序，可以保证每层都是最先访问最右边的节点
        private void dfs(TreeNode root, int depth) {
            if (root == null) return;
            // depth==res.size 说明该深度下，当前节点是第一个被访问的节点
            if (depth == res.size()) res.add(root.val);
            depth++;
            dfs(root.right, depth);
            dfs(root.left, depth);
        }

    }

}
