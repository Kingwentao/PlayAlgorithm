package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 6/24/21
 * description: 剑指Offer-40: 最小的k个数
 */
class GetLeastNumbers {

    public static void main(String[] args) {
        int[] data = {6, 11, 3, 9, 8, 15, 0, 1};
        int[] kMinArray = new Solution().getLeastNumbers(data, 6);
        for (int d : kMinArray) {
            System.out.println("d: " + d);
        }
    }

    public static class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            int[] ret = new int[k];
            if (arr.length <= 0 || k <= 0) return ret;
            int l = 0;
            int r = arr.length - 1;
            int p = partition(arr, l, r);
            while (true) {
                if (p == k - 1) {
                    for (int i = 0; i < k; i++) {
                        ret[i] = arr[i];
                    }
                    break;
                } else if (p < k - 1) {
                    l = p + 1;
                    p = partition(arr, l, r);
                } else {
                    r = p - 1;
                    p = partition(arr, l, r);
                }
            }
            return ret;
        }

        public int partition(int[] aar, int l, int r) {
            int p = aar[r];
            int i = l;
            for (int j = i; j < r; j++) {
                if (aar[j] < p) {
                    swap(aar, i, j);
                    i++;
                }
            }
            swap(aar, i, r);
            return i;
        }

        public static void swap(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }

}
