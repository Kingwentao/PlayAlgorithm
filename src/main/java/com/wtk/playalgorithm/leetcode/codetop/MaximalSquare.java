package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 8/15/21
 * description: 221.最大正方形
 */
class MaximalSquare {

    public static void main(String[] args) { }

    static class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix.length <= 0) return 0;
            int row = matrix.length;
            int column = matrix[0].length;
            int[][] dp = new int[row + 1][column + 1];
            int maxSlide = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                        maxSlide = Math.max(maxSlide, dp[i + 1][j + 1]);
                    }
                }
            }
            return maxSlide * maxSlide;
        }
    }

}
