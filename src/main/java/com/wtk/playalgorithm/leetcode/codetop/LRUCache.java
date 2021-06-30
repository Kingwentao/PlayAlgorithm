package com.wtk.playalgorithm.leetcode.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * author: created by wentaoKing
 * date: created in 6/30/21
 * description: 146.LRU缓存机制
 */
class LRUCache {

    int capacity;
    DoubleLinkedList head;
    DoubleLinkedList tail;
    Map<Integer, DoubleLinkedList> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new DoubleLinkedList();
        tail = new DoubleLinkedList();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoubleLinkedList node = cache.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DoubleLinkedList node = cache.get(key);
        if (node == null) {
            DoubleLinkedList newNode = new DoubleLinkedList(key, value);
            if (cache.size() >= capacity) {
                DoubleLinkedList dNode = removeTail();
                cache.remove(dNode.key);
            }
            cache.put(key, newNode);
            addToHead(newNode);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DoubleLinkedList node) {
        removeNode(node);
        addToHead(node);
    }

    public DoubleLinkedList removeNode(DoubleLinkedList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }

    private void addToHead(DoubleLinkedList node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private DoubleLinkedList removeTail() {
        return removeNode(tail.pre);
    }

    class DoubleLinkedList {
        int key;
        int value;
        DoubleLinkedList pre;
        DoubleLinkedList next;

        public DoubleLinkedList() {
        }

        public DoubleLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
