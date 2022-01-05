package com.wtk.playalgorithm.leetcode.trie;

/**
 * author: created by wentaoKing
 * date: created in 2022/1/5
 * description:
 */
class Trie {

    public static void main(String[] args) {
        String[] dataArray = {"ab", "bcd"};
        Trie trie = new Trie();
        for (String data : dataArray) {
            trie.insert(data.toCharArray());
        }
        char[] find = {'b', 'c'};
        boolean res = trie.find(find);
        System.out.println("find is " + res);
    }

    private TrieNode root = new TrieNode('/');

    public void insert(char[] data) {
        TrieNode p = root;
        for (int i = 0; i < data.length; ++i) {
            int index = data[i] - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(data[i]);
            }
            p = p.children[index];
        }
        p.end++;
    }

    public boolean find(char[] data) {
        TrieNode p = root;
        for (int i = 0; i < data.length; ++i) {
            int index = data[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }

            p = p.children[index];
        }
        // 只是前缀,不能完全匹配
        if(p.end == 0) return false;
        return true;
    }

}
