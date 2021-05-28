package com.wtk.playalgorithm.leetcode.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * author: created by wentaoKing
 * date: created in 4/27/21
 * description: 剑指Offer-40: 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 思路：借助快速选择中的
 */
class LeastNumbers {

    public static void main(String[] args) {
        int[] arr = {0,0,2,3,2,1,1,2,0,4};
        int k = 5;
//        int[] res = getLeastNumbers(arr, k);
//        for (int re : res) {
//            System.out.print(re);
//        }
        System.out.println("");
        int[] res2 = getLeastNumbers2(arr, k);
        for (int re : res2) {
            System.out.print(re);
        }
    }

    /**
     * 我们的目的是寻找最小的 k 个数。假设经过一次 partition 操作，
     * 枢纽元素位于下标 m，也就是说，左侧的数组有 m 个元素，是原数组中最小的 m 个数
     */
    private static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }

        partitionArray(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 借助Java的PriorityQueue，实现一个最小堆
     */
    private static int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer v1, Integer v2) {
                return v2 - v1;
            }
        });
        for (int n : arr) {
            if (pq.size() < k) {
                pq.offer(n);
            } else if (pq.peek() > n) {
                pq.poll();
                pq.offer(n);
            }
        }
        int[] res = new int[pq.size()];
        int i = 0;
        for (int n : pq) {
            res[i++] = n;
        }
        return res;
    }

    private static void partitionArray(int[] arr, int lo, int hi, int k) {
        int p = partition2(arr, lo, hi);
        if (k == p) {
            return;
        } else if (k < p) {
            //note: 为什么两次递归还要传k，而不是k-m，这点比较难理解
            //关键要理解，p返回值是在整个数组的下标，所以传入的还应该是k
            partitionArray(arr, lo, p - 1, k);
        } else {
            partitionArray(arr, p + 1, hi, k);
        }
    }

    private static int partition2(int a[], int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int p = a[lo];
        while (i <= j) {
            while (a[++i] < p) {
                //note: 容易出错，不能和j比较，因为j会变动
                if (i >= hi) break;
            }
            while (a[--j] > p) {
                if (j <= lo) break;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, j, lo);
        return j;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
