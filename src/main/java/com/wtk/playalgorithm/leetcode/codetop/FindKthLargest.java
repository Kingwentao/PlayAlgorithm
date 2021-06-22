package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 6/17/21
 * description: 215.数组中的第K个最大元素
 */
class FindKthLargest {

    public static void main(String[] args) {
//      int[] data = {6, 11, 3, 9, 8, 15, 0, 1};
//        int[] data = {3, 2, 3, 1, 2, 4, 5, 5, 6}; // result 4
        int[] data = {3, 1, 2, 4}; // result 4
        //寻找第k大元素
        int kMax = findKthLargest(data, 2);
        System.out.println("k max value:" + kMax);

//        for (int d: data){
//            System.out.println("d: "+ d);
//        }
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums.length <= 0 || k > nums.length) return -1;
        int left = 0;
        int target = k - 1;
        int right = nums.length - 1;
        while (true) {
            int p = partition(nums, left, right);
            System.out.println("p: " + p);
            if (p == target) {
                //note：返回的是值，不是下标
                return nums[p];
            } else if (p < target) {
                left = p + 1;
            } else {
                right = p - 1;
            }
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
        //note: 这里要return交换后的index，而不是最初定义的pivot
        return i;
    }

    public static void swap(int[] nums, int l, int r) {
        System.out.println("swap: l:" + l + "r :" + r);
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
