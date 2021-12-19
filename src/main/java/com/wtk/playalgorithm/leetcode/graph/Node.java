package com.wtk.playalgorithm.leetcode.graph;

import java.util.ArrayList;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/19
 * description: 图的结点
 */
class Node {
    int value;
    // 入度：指向自己的结点边数
    int in;
    // 出度：指出去的结点边数
    int out;
    ArrayList<Node> nexts;
    ArrayList<Edge> edges;
    Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
