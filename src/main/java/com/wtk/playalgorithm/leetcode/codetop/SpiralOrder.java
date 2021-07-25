package com.wtk.playalgorithm.leetcode.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 7/25/21
 * description: 54.螺旋矩阵
 */
class SpiralOrder {

    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> ret =  new Solution().spiralOrder(array);
        System.out.println("spiral order result: " + ret);
    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix.length <= 0) return null;
            List<Integer> ret = new ArrayList<>();
            int top = 0;
            int left = 0;
            int bottom = matrix.length - 1;
            int right = matrix[0].length - 1;
            while (true) {
                for (int i = left; i <= right; i++) ret.add(matrix[top][i]);
                if (++top > bottom) break;
                for (int i = top; i <= bottom; i++) ret.add(matrix[i][right]);
                if (--right < left) break;
                for (int i = right; i >= left; i--) ret.add(matrix[bottom][i]);
                if (--bottom < top) break;
                for (int i = bottom; i >= top; i--) ret.add(matrix[i][left]);
                if (++left > right) break;
            }
            return ret;
        }
    }

}
