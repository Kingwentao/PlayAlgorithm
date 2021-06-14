package com.wtk.playalgorithm.leetcode.dfs;

/**
 * author: created by wentaoKing
 * date: created in 6/14/21
 * description: 200.岛屿数量
 * 思路：二维数组下的DFS遍历框架，岛屿类问题的通用解法
 * 十分建议参考该题解：
 * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 */
class NumIsLands {

    public static void main(String[] args) {
        char[][] grads = {
                {'0', '1', '0', '0'},
                {'1', '1', '1', '0'},
                {'0', '1', '0', '0'},
                {'0', '0', '0', '1'}};
        int ret = numIslands(grads);
        System.out.println("lands num is " + ret);
    }

    public static int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private static void dfs(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return;
        }

        if (grid[r][c] != '1') return;
        //note：标记是否已经过岛屿，避免重复遍历
        grid[r][c] = '2';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    private static boolean inArea(char[][] grid, int r, int c) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) return true;
        return false;
    }

}
