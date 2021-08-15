package com.wtk.playalgorithm.leetcode.dynamicprogramming;

/**
 * author: created by wentaoKing
 * date: created in 8/15/21
 * description: 62.不同路径
 */
class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int path = new Solution().uniquePaths(m, n);
        System.out.println("path: " + path);
    }

    static class Solution {
        public int uniquePaths(int m, int n) {
            if (m <= 0 || n <= 0) {
                return 0;
            }
            int[][] paths = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        //初始状态
                        paths[i][j] = 1;
                        continue;
                    }
                    paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
                }
            }
            return paths[m - 1][n - 1];
        }
    }
}
