package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 7/15/21
 * description: 88.合并两个有序数组
 */
class MergeArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {0, 1, 2, 0, 0, 0};
        int[] arr2 = {2, 3, 4};
        solution.merge(arr1, 3, arr2, 3);
        for (int n : arr1) {
            System.out.print(n + "、");
        }
    }

    static class Solution {

        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int n1 = m - 1;
            int n2 = n - 1;
            int len = m + n - 1;
            while (n1 >= 0 && n2 >= 0) {
                if (nums2[n2] >= nums1[n1]) {
                    nums1[len--] = nums2[n2--];
                } else {
                    nums1[len--] = nums1[n1--];
                }
            }
            System.arraycopy(nums2, 0, nums1, 0, n2 + 1);
        }
    }

}

