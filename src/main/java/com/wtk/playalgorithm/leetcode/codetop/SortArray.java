package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 8/23/21
 * description: 912.排序数组
 */
class SortArray {

    public static void main(String[] args) {
//        int[] nums = {5, 2, 3, 1};
        int[] nums = {5, 1, 1, 2, 0, 0};
        new Solution().sortArray(nums);
        for (int i : nums) {
            System.out.println("sort array " + i);
        }
    }

    static class Solution {
        public int[] sortArray(int[] nums) {
            if (nums.length <= 1) return nums;
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        void quickSort(int[] nums, int l, int r) {
            if (l >= r) return;
            int p = partition(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1 , r);
        }

        public int partition(int[] nums, int l, int r) {
            // 取中间值，提升算法效率
            int middle = l + (r - l) / 2;
            swap(nums, middle, r);
            int pivot = nums[r];
            int i = l;
            for (int j = i; j <= r; j++) {
                if (nums[j] < pivot) {
                    swap(nums, i, j);
                    i++;
                }
            }
            swap(nums, i, r);
            return i;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }

    }

}
