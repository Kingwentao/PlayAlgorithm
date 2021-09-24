package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 2021/9/24
 * description: 162.寻找峰值
 */
class FindPeakElement {

    public static void main(String[] args) { }

    static class Solution {
        public int findPeakElement(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while(l < r){
                int mid = l + (r - l) / 2;
                if(nums[mid] > nums[mid + 1]){
                    // note: 这里需要把mid纳入，因为有可能mid就是波峰相邻的点
                    r = mid;
                }else{
                    //note: 这里不需要把mid纳入计算了，因为已经确定在它右边了
                    l = mid + 1;
                }
            }
            return l;
        }
    }

}
