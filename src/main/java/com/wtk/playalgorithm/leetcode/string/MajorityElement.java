package com.wtk.playalgorithm.leetcode.string;

/**
 * author: WentaoKing
 * created on: 5/27/21
 * description: 剑指Offer-39: 数组中出现次数超过一半的数字
 * <p>
 * 核心思路：摩尔投票法，核心理念为：票数正负抵消。
 * 如果这个数字存在，那么等于这个数的个数和一定超过所有不等于这个数字的个数和，
 * 所以遇到等于这个数字+1，不等于-1，最终结果一定 >=1
 */
class MajorityElement {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int res = majorityElement(arr);
        System.out.println("marjot result: " + res);
    }

    public static int majorityElement(int[] nums) {
        int sum = 0;
        int target = 0;
        for (int n : nums) {
            //如果上次和结果为0，则将当前值作为目标值
            if (sum == 0) {
                target = n;
            }
            //相同值+1，不同值-1
            if (n == target) {
                sum += 1;
            } else {
                sum += -1;
            }
        }
        //note：考虑不存该数的情况：验证得到的数字是否超过一半
        int count = 0;
        for (int n : nums) {
            if (n == target) count++;
        }
        if (count < nums.length / 2) target = -1;
        return target;
    }

}
