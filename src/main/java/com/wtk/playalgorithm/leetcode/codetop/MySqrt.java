package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 8/16/21
 * description: 69.x的平方根
 */
class MySqrt {
    public static void main(String[] args) {
        int res = new Solution().mySqrt(4);
        System.out.println("res:" + res);
    }

    static class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) return x;
            int left = 1;
            int right = x / 2;
            // 退出循环的时候有 left == right 成立，因此返回 left 或者 right 都可以。不用思考返回 left 还是 right
            while (left < right){
                // note: 要向上取整,  因为定义的边界是 [left, mid - 1]
                // 如果向下取整会变成mid == left,出现死循环
                int mid = left + (right - left + 1) / 2;
                System.out.println("left:" + left + " right:" + right + " mid: " + mid);
                // 先考虑大于x的 ==> 因为题目要求舍弃小数点：如果一个数 mid 的平方大于 x ，那么 mid 一定不是 x 的平方根
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
