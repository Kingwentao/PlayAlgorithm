package com.wtk.playalgorithm.leetcode.graph;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/19
 * description: 树的demo类
 */
class GraphMain {

    public static void main(String[] args) {
        // weight假设都是6
        Integer[][] graphData = {{1,2,6}, {1, 3, 6}, {2, 4, 6}, {2, 3, 6}, {3, 4, 6}};
        Graph graph = Graph.createGraph(graphData);
        graph.bfs(graph.nodes.get(1));
        graph.dfs(graph.nodes.get(1));
    }

}
