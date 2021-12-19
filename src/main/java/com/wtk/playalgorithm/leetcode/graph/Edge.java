package com.wtk.playalgorithm.leetcode.graph;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/19
 * description: 图的边
 */
class Edge {
    // 权重
    int weight;
    Node from;
    Node to;

    Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
