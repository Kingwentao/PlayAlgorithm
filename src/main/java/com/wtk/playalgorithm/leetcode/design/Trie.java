package com.wtk.playalgorithm.leetcode.design;

/**
 * author: created by wentaoKing
 * date: created in 2021/10/10
 * description: 剑指OfferII 62.实现前缀树
 */
class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));   // 返回 False
        System.out.println(trie.startsWith("app"));  // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app")); // 返回 True
        trie.delete("app");
        System.out.println(trie.search("app")); // 返回 False
        System.out.println(trie.search("apple")); // 返回 True
    }

    class TrieNode {
        // 表示此节点结尾的字符串个数
        int end;
        // 经过此节点的字符串个数
        int pass;
        // 记录下一个节点的数组
        TrieNode[] nexts;

        TrieNode() {
            end = 0;
            pass = 0;
            // 下标表示'a-z'26个字符
            // 如果场景不只是26个字符，比如考虑所有字符，那么可使用HashMap/TreeMap存储，用数组太浪费空间
            nexts = new TrieNode[26];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
         root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        cur.pass++;
        char[] wc = word.toCharArray();
        for(char c: wc){
            int index = c - 'a';
            if(cur.nexts[index] == null){
                cur.nexts[index] = new TrieNode();
            }
            cur = cur.nexts[index];
            cur.pass++;
        }
        cur.end++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.isEmpty()) return true;
        char[] wc = word.toCharArray();
        TrieNode cur = root;
        for(char c: wc){
            TrieNode node = cur.nexts[c - 'a'];
            if(node == null) return false;
            cur = node;
        }
        return cur.end > 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.isEmpty()) return true;
        char[] pc = prefix.toCharArray();
        TrieNode cur = root;
        for(char c: pc){
            TrieNode node = cur.nexts[c - 'a'];
            if(node == null) return false;
            cur = node;
        }
        return true;
    }

    public void delete(String word){
        // 确定树中有才能删除，不能边遍历边删
        if(search(word)){
            char[] dc = word.toCharArray();
            TrieNode cur = root;
            cur.pass--;
            for(char c: dc){
                int index = c - 'a';
                // 如果删完后没有经过该字符的，需要删除节点
                if(--cur.nexts[index].pass == 0){
                    cur.nexts[index] = null;
                }
                cur = cur.nexts[index];
            }
            cur.end --;
        }
    }

}
