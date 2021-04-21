package com.wtk.playalgorithm.leetcode.design;

import java.util.HashMap;

/**
 * author: created by wentaoKing
 * date: created in 4/19/21
 * description: LRU缓存算法
 * 核心思路：设计，hash表+双向链表
 */
class LRUCache {

    int capacity;
    //快速查找
    HashMap<Integer, DoubleLinkNode> cache;
    //缓存中的数量
    int size;
    // 使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，
    // 这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在
    DoubleLinkNode head;
    DoubleLinkNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DoubleLinkNode();
        tail = new DoubleLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoubleLinkNode node = cache.get(key);
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DoubleLinkNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DoubleLinkNode newNode = new DoubleLinkNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DoubleLinkNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.val = value;
            moveToHead(node);
        }
    }


    // 在链表头部添加节点 x，时间 O(1)
    public void addToHead(DoubleLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除链表中最后一个节点，并返回该节点，时间 O(1)
    public DoubleLinkNode removeTail() {
        DoubleLinkNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public void removeNode(DoubleLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(DoubleLinkNode node){
        removeNode(node);
        addToHead(node);
    }

    private class DoubleLinkNode {
        private DoubleLinkNode prev, next;
        private int key, val;

        public DoubleLinkNode() {
        }

        DoubleLinkNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }

    public static void main(String[] args) {

    }
}
