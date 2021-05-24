package com.wtk.playalgorithm.leetcode.tree;

/**
 * author: WentaoKing
 * created on: 5/24/21
 * description: 剑指Offer-36: 二叉搜索树与双向链表
 */
class TreeToDoublyList {

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) return;
        //note：中序遍历（左）
        dfs(cur.left);
        //双向连接
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        //note：中序遍历（右）
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}


