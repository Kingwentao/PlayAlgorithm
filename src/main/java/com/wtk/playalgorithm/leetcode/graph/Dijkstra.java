package com.wtk.playalgorithm.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * author: created by wentaoKing
 * date: created in 2022/1/2
 * description: dijkstra最短路径算法
 */
class Dijkstra {

    public static void main(String[] args) {
    }

    class Solution {

        public Map<Node, Integer> dijkstra(Node head, Graph graph) {
            // 从head出发到所有点的最小距离, key: 目的点 value: head出发到key的最小距离
            HashMap<Node, Integer> distances = new HashMap<>();
            distances.put(head, 0);
            // 已经求过距离的节点
            HashSet<Node> selectedNodes = new HashSet<>();
            // 在没有算过距离的点中，选择距离最小的一个点
            Node minNode = getMinDistanceAndUnselectedNode(distances, selectedNodes);
            while (minNode != null) {
                int distance = distances.get(minNode);
                for (Edge edge : minNode.edges) {
                    Node toNode = edge.to;
                    // 添加/更新最短距离
                    if (!distances.containsKey(toNode)) {
                        distances.put(toNode, distance + edge.weight);
                    } else {
                        distances.put(toNode, Math.min(distances.get(toNode), distance + edge.weight));
                    }
                }
                selectedNodes.add(minNode);
                minNode = getMinDistanceAndUnselectedNode(distances, selectedNodes);
            }
            return distances;
        }

        private Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distances,
                                                     HashSet<Node> selectedNodes) {
            Node minNode = null;
            int minDistance = Integer.MAX_VALUE;
            for (Map.Entry<Node, Integer> entry : distances.entrySet()) {
                Node node = entry.getKey();
                int distance = entry.getValue();
                if (!selectedNodes.contains(node) && distance < minDistance) {
                    minDistance = distance;
                    minNode = node;
                }
            }
            return minNode;
        }
    }

}
