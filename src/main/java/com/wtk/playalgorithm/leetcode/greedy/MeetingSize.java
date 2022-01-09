package com.wtk.playalgorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * author: created by wentaoKing
 * date: created in 2022/1/9
 * description: 计算一个时间段可容纳的最多会议场次
 */
class MeetingSize {

    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{new Interval(10, 11), new Interval(11, 12), new Interval(12, 13)};
        int size = new Solution().getMaxMeetingSize(intervals);
        System.out.println("可以容纳最多" + size + "场会议");
    }

    public static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Solution {

        /**
         * @param intervals 会议时间范围
         * @return
         */
        public int getMaxMeetingSize(final Interval[] intervals) {
            Arrays.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.end - o2.end;
                }
            });
            int timePoint = intervals[0].start;
            int size = 0;
            for (int i = 0; i < intervals.length; i++) {
                if (timePoint <= intervals[i].start) {
                    size++;
                    timePoint = intervals[i].end;
                }
            }
            return size;
        }
    }
}
