package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 2021/10/16
 * description: 55.跳跃游戏
 */
class CanJump {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        boolean res = new Solution().canJump(nums2);
        System.out.println("res: " + res);
    }

    static class Solution {

        // 贪心思路：找到每次都跳最远的点。
        // 因为如果可以跳到某个点，就说明一定可以跳到它之前的所有点
        public boolean canJump(int[] nums) {
            int len = nums.length;
            if (len < 1) return false;
            // 能跳的最远的点（下标）
            int k = 0;
            for (int i = 0; i < len; i++) {
                if (i > k) return false;
                k = Math.max(k, i + nums[i]);
            }
            return true;
        }
    }

}
