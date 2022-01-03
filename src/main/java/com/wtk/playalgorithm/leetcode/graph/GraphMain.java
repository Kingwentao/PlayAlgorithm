package com.wtk.playalgorithm.leetcode.graph;

/**
 * author: created by wentaoKing
 * date: created in 2021/12/19
 * description: 树的demo类
 */
class GraphMain {

    public static void main(String[] args) {
        // weight假设都是6
        Integer[][] graphData = {{1, 2, 6}, {1, 3, 6}, {2, 4, 6}, {2, 3, 6}, {3, 4, 6}};
        Graph graph = Graph.createGraph(graphData);
        graph.bfs(graph.nodes.get(1));
        graph.dfs(graph.nodes.get(1));

        // 图的搜索
        System.out.println("图的搜索, bfs");
        Node start = graph.nodes.get(1);
        Node end = graph.nodes.get(4);
        System.out.println("start:" + start.value);
        System.out.println("end:" + end.value);
//        new GraphSearch.Solution().bfs(graph, start, end);
        new GraphSearch.Solution().dfs(graph, start, end);
    }

}
