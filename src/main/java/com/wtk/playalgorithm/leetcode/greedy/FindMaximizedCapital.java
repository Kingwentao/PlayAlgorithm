package com.wtk.playalgorithm.leetcode.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * author: created by wentaoKing
 * date: created in 2022/1/18
 * description: 最大的投资利润
 * 贪心算法：每次投资利润最大的项目
 */
class FindMaximizedCapital {

    /**
     * 投资的项目
     */
    static class Project{
        // 本金
        int capital;
        // 利润
        int profit;

        Project(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }

    static class Solution {

        class MinCostComparator implements Comparator<Project>{

            @Override
            public int compare(Project o1, Project o2) {
                return o1.capital - o2.capital;
            }

        }

        class MaxProfitComparator implements  Comparator<Project>{

            @Override
            public int compare(Project o1, Project o2) {
                return o2.profit - o1.profit;
            }
        }

        /**
         *
         * @param k 最多可投资的项目数
         * @param w 本金
         * @param capital 投资项目成本
         * @param profits 投资项目后最终所得利润
         * @return
         */
        int findMaximizedCapital(int k, int w, int[] capital, int[] profits){
            PriorityQueue<Project> minCost = new PriorityQueue<>(new MinCostComparator());
            PriorityQueue<Project> maxProfit = new PriorityQueue<>(new MaxProfitComparator());
            // 把所有项目都扔进最小堆里，按成本排序
            for (int i = 0; i < profits.length; i++){
                minCost.add(new Project(capital[i], profits[i]));
            }
            for(int i = 0; i < k; i++){
                // 把低于成本的扔进最大堆里
                while (!minCost.isEmpty() && minCost.peek().capital < w){
                    maxProfit.add(minCost.poll());
                }
                // 最大堆为空，说明没有可继续投资的项目了，提前结束
                if(maxProfit.isEmpty()) break;
                w += maxProfit.poll().profit;
            }
            return w;
        }

    }
}
