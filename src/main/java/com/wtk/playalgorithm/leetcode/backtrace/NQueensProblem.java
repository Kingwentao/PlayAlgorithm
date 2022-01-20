package com.wtk.playalgorithm.leetcode.backtrace;

/**
 * author: created by wentaoKing
 * date: created in 2022/1/20
 * description: n皇后问题
 */
class NQueensProblem {

    static int n = 8;
    static int count = 0;

    public static void main(String[] args) {
        new Solution().nQueens(0);
    }

    static class Solution {
        int[] result = new int[n];

        public void nQueens(int row) {
            if (n == row) {
                System.out.println("第" + (++count) + "种摆法：");
                printQueues(result);
                return;
            }
            for (int column = 0; column < n; column++) {
                if (isOk(row, column)) {
                    result[row] = column;
                    // 可以放置皇后，进行下一行
                    nQueens(row + 1);
                }
            }
        }

        private boolean isOk(int row, int column) {
            for (int i = row - 1; i >= 0; i--) {
                // 同一列/斜对角线
                if (result[i] == column || Math.abs(result[i] - column) == Math.abs(row - i))
                    return false;
            }
            return true;
        }

        private void printQueues(int[] result) {
            for (int row = 0; row < result.length; ++row) {
                for (int column = 0; column < result.length; ++column) {
                    if (result[row] == column) System.out.print("Q ");
                    else System.out.print("* ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
