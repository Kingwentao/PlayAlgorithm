package com.wtk.playalgorithm.leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * author: created by wentaoKing
 * date: created in 2022/1/3
 * description: 树的搜索方式
 * ex: s 到 t 的最短路径。
 */
class GraphSearch {

    public static class Solution {

        /**
         * 广度优先搜索
         *
         * @param s 起始点
         * @param t 目的点
         */
        public void bfs(Graph graph, Node s, Node t) {
            if (s == t) return;
            int size = graph.nodes.size();
            // 记录已经被访问的顶点，用来避免顶点被重复访问
            Map<Node, Boolean> visited = new HashMap<>();
            visited.put(s, true);
            // 存储已经被访问、但相连的顶点还没有被访问的顶点。
            Queue<Node> queue = new LinkedList<>();
            queue.add(s);
            // prev 用来记录搜索路径,
            // 顶点 2 的邻接表访问到顶点 3，那 prev[3]就等于 2。为了正向打印出路径，需要递归地来打印
            int[] prev = new int[size + 1];
            for (int i = 0; i < size; ++i) {
                prev[i] = -1;
            }
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                for (Node next : node.nexts) {
                    if (visited.containsKey(next)) continue;
                    prev[next.value] = node.value;
                    if (next == t) {
                        printSearchResult(prev, s.value, t.value);
                        return;
                    }
                    visited.put(next, true);
                    queue.add(next);
                }
            }
        }

        /**
         * 深度优先搜索
         */
        public void dfs(Graph graph, Node s, Node t) {
            if (s == t) return;
            int size = graph.nodes.size();
            // 记录已经被访问的顶点，用来避免顶点被重复访问
            Map<Node, Boolean> visited = new HashMap<>();
            visited.put(s, true);
            int[] prev = new int[size + 1];
            for (int i = 0; i < size; ++i) {
                prev[i] = -1;
            }
            recurDfs(s, t, visited, prev);
            printSearchResult(prev, s.value, t.value);
        }

        private void recurDfs(Node s, Node t, Map<Node, Boolean> visited, int[] prev) {
            visited.put(s, true);
            if (s == t) {
                return;
            }
            for (Node next : s.nexts) {
                if (visited.containsKey(next)) continue;
                prev[next.value] = s.value;
                recurDfs(next, t, visited, prev);
            }
        }

        private void printSearchResult(int[] prev, int s, int t) {
            if (prev[t] != -1 && s != t) {
                printSearchResult(prev, s, prev[t]);
            }
            if (s != t) {
                System.out.print("->");
            }
            System.out.print(t);
        }

    }
}
