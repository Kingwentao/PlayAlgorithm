package com.wtk.playalgorithm.leetcode.array;

/**
 * author: WentaoKing
 * created on: 4/29/21
 * description:
 */
class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix ={{0,1,2},{2,3,4},{5,6,7}};
        boolean result = findNumberIn2DArray(matrix,4);
        System.out.println("find result: " + result);
    }

    static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0  && j < matrix[0].length ){
            int value = matrix[i][j];
            if (value == target){
                return true;
            }else if (value > target){
                ++j;
            }else {
                --i;
            }
        }
        return false;
    }

}
