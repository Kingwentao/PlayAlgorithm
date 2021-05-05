package com.wtk.playalgorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 5/5/21
 * description: 螺旋矩阵
 * 核心思想：按照形状向内缩圈 + 递归处理
 */
class SpiralOrder {

    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> ret = spiralOrder(array);
        System.out.println("spiral order result: " + ret);
    }

    public static List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int m = mat.length, n = mat[0].length;
        circle(mat, 0, 0, m - 1, n - 1, ans);
        return ans;
    }

    static void circle(int[][] mat, int x1, int y1, int x2, int y2, List<Integer> ans) {
        if (x2 < x1 || y2 < y1) return;
        //只有一行
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) ans.add(mat[x1][i]);
            //note: 记得return
            return;
        }
        //只有一列
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) ans.add(mat[i][y1]);
            return;
        }
        //遍历当前的圈
        for (int i = y1;i < y2;i++) ans.add(mat[x1][i]);
        for (int i = x1;i < x2;i++) ans.add(mat[i][y2]);
        for (int i = y2;i > y1;i--) ans.add(mat[x2][i]);
        for (int i = x2;i > x1;i--) ans.add(mat[i][y1]);
        //向内缩圈
        circle(mat,x1 + 1,y1 + 1,x2 - 1,y2 - 1, ans);
    }
}
