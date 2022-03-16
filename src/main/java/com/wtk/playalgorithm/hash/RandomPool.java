package com.wtk.playalgorithm.hash;

import java.util.HashMap;

/**
 * author: created by wentaoKing
 * date: created in 2022/3/16
 * description: O（1）时间复杂度，等概率获取一个随机key值
 */
class RandomPool<K> {

    private HashMap<Integer, K> indexToKey;
    private HashMap<K, Integer> keyToIndex;
    int size;

    RandomPool() {
        indexToKey = new HashMap<>();
        keyToIndex = new HashMap<>();
        size = 0;
    }

    void insert(K key) {
        if (!keyToIndex.containsKey(key)) {
            indexToKey.put(size, key);
            keyToIndex.put(key, size);
            ++size;
        }
    }

    void delete(K key) {
        if (!keyToIndex.containsKey(key)) {
            int deleteIndex = keyToIndex.get(key);
            int lastIndex = size--;
            K lastKey = indexToKey.get(lastIndex);
            indexToKey.put(deleteIndex, lastKey);
            keyToIndex.put(lastKey, deleteIndex);
            indexToKey.remove(lastIndex);
            keyToIndex.remove(lastKey);
        }
    }

    K getRandomKey() {
        if (size == 0) return null;
        int randomIndex = (int) (Math.random() * size);
        return indexToKey.get(randomIndex);
    }

}

class RandomTest {
    public static void main(String[] args) {
        RandomPool<String> randomPool = new RandomPool<>();
        randomPool.insert("king");
        randomPool.insert("wen");
        randomPool.insert("tao");
        randomPool.insert("is");
        randomPool.insert("a");
        randomPool.insert("boy");
        for (int i = 0; i < 10; i++) {
            String key = randomPool.getRandomKey();
            System.out.println("random key is " + key);
        }
    }
}