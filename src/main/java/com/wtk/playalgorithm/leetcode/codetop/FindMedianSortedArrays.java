package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 2021/10/12
 * description: 4.寻找两个正序数组的中位数
 */
class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double res = new Solution().findMedianSortedArrays(nums1, nums2);
        System.out.println("median: " + res);
    }

    static class Solution {

        // 时间复杂度为O（m+n)
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int len = len1 + len2;
            int start1 = 0, start2 = 0;
            int left = -1, right = -1;
            for (int i = 0; i <= len / 2; i++) {
                left = right;
                // note: 需要先检测start2 >= len2， 否则后面判断取值会越界
                if(start1 < len1 && (start2 >= len2 || nums1[start1] < nums2[start2] )){
                    right = nums1[start1++];
                }else {
                    right = nums2[start2++];
                }
            }
            if(len % 2 == 0){
                System.out.println("left " + left);
                System.out.println("right " + right);
                return (left + right) * 1d / 2;
            }else {
                return right;
            }
        }

    }
}
