package com.wtk.playalgorithm.leetcode.tree;

import com.wtk.playalgorithm.leetcode.linklist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/1
 * description: 树的三种遍历
 */
class TreeTraversal {

    public static void main(String[] args) {
    }

    // 递归解法
    class Solution {

        // 先序遍历（中、左、右）
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            preorder(root, ret);
            return ret;
        }

        void preorder(TreeNode root, List<Integer> ret) {
            if (root == null) return;
            // 1
            // 递归序第1次经过的值
            ret.add(root.val);
            preorder(root.left, ret);
            preorder(root.right, ret);
        }

        // 中序遍历（左、中、右）
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            inorder(root, ret);
            return ret;
        }

        void inorder(TreeNode root, List<Integer> ret) {
            if (root == null) return;
            inorder(root.left, ret);
            // 2
            // 2
            // 递归序第二次经过的值
            ret.add(root.val);
            inorder(root.right, ret);
        }

        // 后序遍历（左、右、中）
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            postorder(root, ret);
            return ret;
        }

        void postorder(TreeNode root, List<Integer> ret) {
            if (root == null) return;
            postorder(root.left, ret);
            postorder(root.right, ret);
            // 3
            // 3
            // 递归序第三次经过的值
            ret.add(root.val);
        }

    }

    // 非递归解法
    class Solution2 {

        // 前序
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            if (root == null) return ret;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            // 压栈顺序：中、右、左，每次弹出一个，记录下来
            while (!stack.isEmpty()) {
                root = stack.pop();
                ret.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
            return ret;
        }

        // 中序
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            // 压栈顺序：先把左子树结点全压入栈，压完后，开始弹出，弹出时把右子树结点（一个新的左中右树）压入
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    ret.add(root.val);
                    root = root.right;
                }
            }
            return ret;
        }

        // 后序遍历
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            if (root == null) return ret;
            Stack<TreeNode> stack1 = new Stack<>();
            // 收集栈，收集完再打印，收集顺序：中右左 ==> 输出顺序就是后序遍历顺序
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            // 压栈顺序: 压入左、右，弹出结点时加入到收集栈中
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                stack2.push(root);
                if (root.left != null) {
                    stack1.push(root.left);
                }
                if (root.right != null) {
                    stack1.push(root.right);
                }
            }
            while (!stack2.isEmpty()) {
                ret.add(stack2.pop().val);
            }
            return ret;
        }

    }

}
