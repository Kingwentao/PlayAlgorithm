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


    /**
     * 优化算法：使用自定义的堆结构代替循环遍历
     */
    public Map<Node, Integer> dijkstra2(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        HashMap<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeHeap.NodeRecord nodeRecord = nodeHeap.pop();
            Node node = nodeRecord.node;
            int distance = nodeRecord.distance;
            for (Edge edge : node.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, distance + edge.weight);
            }
            result.put(node, distance);
        }
        return result;
    }

    /**
     * 自定义堆
     */
    public static class NodeHeap {

        private Node[] nodes;
        // 堆中节点的下标，如果被移出堆，value置为-1
        private HashMap<Node, Integer> heapIndexMap;
        private HashMap<Node, Integer> distanceMap;
        private int size;

        NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = size;
        }

        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        public boolean isEmpty() {
            return heapIndexMap.isEmpty();
        }

        private boolean inHeap(Node node) {
            return heapIndexMap.containsKey(node) && heapIndexMap.get(node) != -1;
        }

        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }

        public void addOrUpdateOrIgnore(Node node, int distance) {
            // update
            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distance, distanceMap.get(node)));
                insertHeap(node, heapIndexMap.get(node));
            }
            // add
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, distance);
                distanceMap.put(node, distance);
                insertHeap(node, size++);
            }
            // 进来不在堆上说明算过，ignore
        }

        private void insertHeap(Node node, Integer index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public NodeRecord pop() {
            NodeRecord record = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            // 把堆顶和最后一个结点交换，然后在堆化交换后的堆顶结点
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size - 1]);
            nodes[size - 1] = null;
            heapify(0, --size);
            return record;
        }

        // 自上往下堆化
        private void heapify(int i, int size) {
            while (true) {
                int minPos = i;
                if (i * 2 <= size && distanceMap.get(nodes[i]) > distanceMap.get(nodes[i * 2])) {
                    minPos = i * 2;
                }
                if (i * 2 + 1 <= size && distanceMap.get(nodes[i]) > distanceMap.get(nodes[i * 2 + 1])) {
                    minPos = i * 2 + 1;
                }
                if (minPos == i) break;
                swap(minPos, i);
                i = minPos;
            }
        }

        class NodeRecord {
            Node node;
            int distance;

            public NodeRecord(Node node, int distance) {
                this.node = node;
                this.distance = distance;
            }
        }

    }


}
