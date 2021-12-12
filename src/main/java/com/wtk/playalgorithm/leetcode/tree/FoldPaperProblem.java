package com.wtk.playalgorithm.leetcode.tree;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/12
 * description: 842.折纸
 */
class FoldPaperProblem {

    public static void main(String[] args) {
    }

    public class Solution {

        StringBuilder sb = new StringBuilder();

        public String getString(int n) {
            fold(1, n, true);
            return sb.toString();
        }

        /**
         * 折纸规律：如同一个二叉树，根和左都是凹的，右子树是凸的，中序遍历就是它的打印结果。
         *
         * @param i      当前层数
         * @param n      总层数
         * @param isDown true: 凹的
         */
        public void fold(int i, int n, boolean isDown) {
            if (i > n) return;
            // 左
            fold(i + 1, n, true);
            // 中
            if (isDown) sb.append("0");
            else sb.append("1");
            // 右
            fold(i + 1, n, false);
        }

    }
}
