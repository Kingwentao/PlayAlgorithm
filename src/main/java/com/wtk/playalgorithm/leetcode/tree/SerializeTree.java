package com.wtk.playalgorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/12
 * description: 297.二叉树的序列化与反序列化
 */
class SerializeTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        TreeNode head = TreeUtil.generateCompleteTree(arr, 0);
        String s = new Codec().serialize(head);
        System.out.println("serialize res " + s);
        TreeNode res = new Codec().deserialize(s);
        ArrayList<Integer> print = TreeUtil.printFromTopToBottom(res);
        for (int value : print) {
            System.out.println("print: " + value);
        }
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "#_";
            }
            String res = root.val + "_";
            res += serialize(root.left);
            res += serialize(root.right);
            return res;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] values = data.split("_");
            Queue<String> queue = new LinkedList<>();
            for (int i = 0; i != values.length; i++) {
                queue.add(values[i]);
            }
            return reconPreNode(queue);
        }

        private TreeNode reconPreNode(Queue<String> queue) {
            String value = queue.poll();
            if (value == null || value.equals("#")) {
                return null;
            }
            TreeNode head = new TreeNode(Integer.valueOf(value));
            head.left = reconPreNode(queue);
            head.right = reconPreNode(queue);
            return head;
        }
    }

}
