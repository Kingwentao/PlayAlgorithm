package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 2021/9/19
 * description: 33.搜索旋转排序数组
 */
class SearchRotateSortArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int res = new Solution().search(nums, 0);
        System.out.println("search res" + res);
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;
            while(lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if(nums[mid] == target){
                    return mid;
                }
                // 1.1 判断mid在左区间还是右区间 == 左区间
                // note: 这里的 = 容易遗漏，mid刚好在lo，作为左区间处理
                if(nums[mid] >= nums[lo]){
                    // 2.1 判断target是否属于左区间：只有在lo 、mid 二者中间才满足
                    if(target >= nums[lo] && target < nums[mid]){
                        hi = mid - 1;
                    }else {
                        lo = mid + 1;
                    }
                // 1.2.判断mid在左区间还是右区间 == 右区间
                }else{
                    // 2.2 判断target是否属于右区间
                    if(target > nums[mid] && target <= nums[hi]){
                        lo = mid + 1;
                    }else{
                        hi = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
