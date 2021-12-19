package com.wtk.playalgorithm.leetcode.graph;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/19
 * description: 图的结构
 */
class Graph {
    HashMap<Integer, Node> nodes;
    HashSet<Edge> edges;

    Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

    /**
     * @param matrix 二维数组，每一行有三个数，分别表示from、to、weight
     * @return graph
     */
    static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

    void dfs(Node node) {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> record = new HashSet<>();
        stack.push(node);
        record.add(node);
        System.out.println("dfs forEach: ");
        System.out.println("cur Node: " + node.value);
        while (!stack.isEmpty()) {
            Node pNode = stack.pop();
            for (Node nNode : pNode.nexts) {
                if (!record.contains(nNode)) {
                    stack.push(pNode);
                    stack.push(nNode);
                    record.add(nNode);
                    System.out.println("cur Node: " + nNode.value);
                    break;
                }
            }
        }
    }

    void bfs(Node node) {
        Deque<Node> deque = new LinkedList<>();
        HashSet<Node> record = new HashSet<>();
        deque.add(node);
        record.add(node);
        System.out.println("bfs forEach: ");
        while (!deque.isEmpty()) {
            Node pNode = deque.poll();
            System.out.println("cur Node: " + pNode.value);
            for (Node nNode : pNode.nexts) {
                if (record.contains(nNode)) continue;
                deque.add(nNode);
                record.add(nNode);
            }
        }
    }

}
