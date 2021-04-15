package com.wtk.playalgorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * author: created by wentaoKing
 * date: created in 4/15/21
 * description: 树工具类
 */
class TreeUtil {

    /**
     * 生成一个树
     */
    static TreeNode generateTree(int[] arr, int num) {
        TreeNode root = new TreeNode(arr[num]);
        if (num * 2 + 1 < arr.length) {
            root.left = generateTree(arr, num * 2 + 1);
        }
        if (num * 2 + 2 < arr.length) {
            root.right = generateTree(arr, num * 2 + 2);
        }
        return root;
    }

    //从上到下打印
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode current;
        int cur, last;
        queue.add(root);
        while (!queue.isEmpty()) {
            cur = 0;
            last = queue.size();
            while (cur < last) {
                current = queue.poll();
                list.add(current.val);
                cur++;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return list;
    }

}

