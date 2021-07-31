package com.wtk.playalgorithm.leetcode.codetop;

import java.util.Arrays;

/**
 * author: created by wentaoKing
 * date: created in 7/31/21
 * description: 31.下一个排列
 * 核心：弄懂算法的实现，代码实现较为简单
 * 该题解足矣：
 * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 */
class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 5, 7, 6, 4};
        new Solution().nextPermutation(nums);
    }

    static class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            if (len <= 1) return;
            //从右往左的第一组升序元素的下标 [ri < rj]
            int ri = 0;
            int rj = 0;
            for (int i = len - 2; i >= 0; i--) {
                if (nums[i + 1] > nums[i]) {
                    rj = i + 1;
                    ri = i;
                    break;
                }
            }
            //从右往左寻找第一个比ri大的数，交换 ==》 [rj,len]必然是降序
            for (int i = len - 1; i >= 0; i--) {
                if (nums[i] > nums[ri]) {
                    swap(nums, i, ri);
                    break;
                }
            }
            // 对[rj，len]进行升序排序后，此时的序列就是下一个较大的排序组合
            Arrays.sort(nums, rj, len);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }

}
