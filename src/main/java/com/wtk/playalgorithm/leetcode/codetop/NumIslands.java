package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 7/27/21
 * description: 200.岛屿数量
 */
class NumIslands {

    public static void main(String[] args) {
        char[][] grads = {
                {'0', '1', '0', '0'},
                {'1', '1', '1', '0'},
                {'0', '1', '0', '0'},
                {'0', '0', '0', '1'}};
        int ret = new Solution().numIslands(grads);
        System.out.println("lands num is " + ret);
    }

    static class Solution {

        public int numIslands(char[][] grid) {
            int num = 0;
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[i].length; j++){
                    if (grid[i][j] == '1'){
                        dfs(grid, i , j);
                        num++;
                    }
                }
            }
            return num;
        }

        public void dfs(char[][] grid, int r, int c) {
            if (!isArea(grid, r, c)) return;
            //去除水、遍历过的
            if (grid[r][c] != '1') return;
            //标记已遍历
            grid[r][c] = '2';
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
        }

        private boolean isArea(char[][] grid, int r, int c) {
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length) {
                return false;
            }
            return true;
        }

    }

}
