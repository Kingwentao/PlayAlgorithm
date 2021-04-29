package com.wtk.playalgorithm.leetcode.array;

/**
 * author: WentaoKing
 * created on: 4/29/21
 * description: 剑指Offer-04: 二维数组中的查找
 * Q：每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 核心思路：以左下角/右上角为起始比较点。这样就可以每次都只需要比较一行/一列
 * 如果从左上角/右下角就没有这样的便利性
 */
class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2}, {2, 3, 4}, {5, 6, 7}};
        boolean result = findNumberIn2DArray(matrix, 9);
        System.out.println("find result: " + result);
    }

    static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            int value = matrix[i][j];
            if (value == target) {
                return true;
            } else if (value > target) {
                --i;
            } else {
                ++j;
            }
        }
        return false;
    }

}
