package com.wtk.playalgorithm.leetcode.trie;

/**
 * author: created by wentaoKing
 * date: created in 2022/1/5
 * description: 前缀树结点结构
 */
class TrieNode {
    // 当前结点数据
    char data;
    // 记录是否是最后一个点，可以用来判断是否完全匹配
    int end;
    // 子结点数据，如果数组某个为空，表示不存在该结点
    TrieNode[] children;

    TrieNode(char data) {
        this.data = data;
        // 表示 a 到 z 这 26 个小写字母。0:a 25:z
        children = new TrieNode[26];
        end = 0;
    }
}
