package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 8/16/21
 * description: 69.x的平方根
 */
class MySqrt {
    public static void main(String[] args) {
        int res = new Solution().mySqrt(8);
        System.out.println("res:" + res);
    }

    static class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) return x;
            int left = 0;
            int right = x / 2;
            while (left < right){
                // note: 要向上取整,  因为定义的边界是 [left, mid - 1]
                // 如果向下取整会变成mid == left,出现死循环
                int mid = left + (right - left + 1) / 2;
                if (mid > x / mid){
                    right = mid - 1;
                }else {
                    left = mid;
                }
            }
            return left;
        }
    }

}
