package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 6/17/21
 * description: 215.数组中的第K个最大元素
 */
class FindKthLargest {

    public static void main(String[] args) {
//      int[] data = {6, 11, 3, 9, 8, 15, 0, 1};
        int[] data = {3, 2, 3, 1, 2, 4, 5, 5, 6}; // result 4
        //寻找第k大元素
        int kMax = findKthLargest(data, 4);
        System.out.println("k max value:" + kMax);
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums.length <= 0 || k > nums.length) return -1;
        int p = partition(nums, 0, nums.length - 1);
        while (true) {
            if (p + 1 == k) {
                //note：返回的是值，不是下标
                return nums[p];
            }
            p = partition(nums, 0, p - 1);
        }
    }

    public static int partition(int[] nums, int l, int r) {
        int p = nums[r];
        int i = l;
        for (int j = i; j < r; j++) {
            //note: 把大的置换到前面来
            if (nums[j] > p) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return r;
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
