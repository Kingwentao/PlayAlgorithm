package com.wtk.playalgorithm.leetcode.codetop;

import java.util.Arrays;

/**
 * author: created by wentaoKing
 * date: created in 8/18/21
 * description: 56.合并区间
 */
class MergeInterval {

    public static void main(String[] args) { }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            int intervalSize = intervals.length;
            if (intervalSize <= 1) return intervals;
            // 对区间左升序排列
//            Arrays.sort(intervals, (t1, t2) -> t1[0] - t2[0]);
            // 遍历区间
            int[][] res = new int[intervalSize][2];
            int idx = -1;
            for (int i = 0; i < intervalSize; i++){
                // 被包含，直接加入
                if (idx == -1 || intervals[i][0] > res[idx][1]){
                    res[++idx]  = intervals[i];
                }else {
                    // 反之，更新区间的右边
                    res[idx][1] = Math.max(intervals[i][1], res[idx][1]);
                }
            }
            return Arrays.copyOf(res, idx + 1);
        }
    }

}
