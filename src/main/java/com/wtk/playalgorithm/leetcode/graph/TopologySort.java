package com.wtk.playalgorithm.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/23
 * description: 拓扑排序
 */
class TopologySort {

    public static void main(String[] args) {

    }

    class Solution {
        public List<Node> sortTopology(Graph graph) {
            // 所有结点的入度
            HashMap<Node, Integer> inMap = new HashMap<>();
            // 入度为0的队列
            Queue<Node> zeroInList = new LinkedList<>();
            // 记录所有点的入度
            for (Node node : graph.nodes.values()) {
                if (node.in == 0) zeroInList.add(node);
                inMap.put(node, node.in);
            }
            List<Node> result = new ArrayList<>();
            // 依次找到入度为0的结点就是拓扑排序的结果
            while (!zeroInList.isEmpty()) {
                Node node = zeroInList.poll();
                result.add(node);
                for (Node next : node.nexts) {
                    inMap.put(next, inMap.get(next) - 1);
                    if (inMap.get(next) == 0) zeroInList.add(next);
                }
            }
            return result;
        }
    }
}
