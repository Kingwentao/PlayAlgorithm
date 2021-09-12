package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 2021/9/12
 * description: 41.缺失的第一个正数
 */
class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3, 4, - 1, 1};
        int res = new Solution().firstMissingPositive(nums);
        System.out.println(res);
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;
            if(len < 1) return 0;
            // 原地哈希
            for(int i = 0; i < len; i++){
                // note: 这里需要使用while，否则被迫交换的元素后续不会被再次遍历到
                while (nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]){
                    swap(nums, i, nums[i] - 1);
                }
            }
            // 寻找丢失的正数
            for(int i = 0; i < len; i++){
                if(nums[i] != i + 1){
                    return  i+1;
                }
            }
            return len + 1;
        }

        private void swap(int[] nums, int x, int y){
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] =  temp;
        }
    }
}
