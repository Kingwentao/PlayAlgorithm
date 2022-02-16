package com.wtk.playalgorithm.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 2022/2/14
 * description: 面试题: 汉诺塔问题
 */
class Hanota {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        new Solution().hanota(A, B, C);
    }

    static class Solution {
        /**
         * 将A上的所有盘子,借助B，移动到C上
         * @param A 原柱子
         * @param B 辅助柱子
         * @param C 目标柱子
         */
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            int len = A.size();
            if (len > 0) {
                move(len, "A", "C", "B");
                move2(len, A, B, C);
            }
        }

        public void move(int i, String start, String target, String other) {
            if (i == 1) {
                System.out.println("move 1 from " + start + " to " + target);
            } else {
                move(i - 1, start, other, target);
                System.out.println("move " + i + " from " + start + " to " + target);
                move(i - 1, other, target, start);
            }
        }

        public void move2(int i, List<Integer> start, List<Integer> target, List<Integer> other) {
            if (i == 1) {
                target.add(start.remove(start.size() - 1));
                return;
            }
            move2(i - 1, start, other, target);
            target.add(start.remove(start.size() - 1));
            move2(i - 1, other, target, start);
        }
    }

}