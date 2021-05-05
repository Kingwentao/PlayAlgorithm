package com.wtk.playalgorithm.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 5/4/21
 * description: 路径总和 II：找出所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 核心思路：深度优先搜索
 */
class PathSum {

    private static List<List<Integer>> ret = new LinkedList<>();
    private static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) {}

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public static void dfs(TreeNode root, int sum) {
        if (root == null) return;
        deque.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<>(deque));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        deque.pollLast();
    }

}
