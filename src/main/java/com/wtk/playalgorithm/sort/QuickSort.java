package com.wtk.playalgorithm.sort;

/**
 * author: created by wentaoKing
 * date: created in 3/6/21
 * description: 快速排序: 它的处理过程是由上到下的，先分区，然后再处理子问题
 * 快速排序通过设计巧妙的原地分区函数，可以实现原地排序，解决了归并排序占用太多内存的问题。
 */
class QuickSort {

    private static int[] data = {6, 11, 3, 9, 8};

    public static void main(String[] args) {
        quickSort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.println("quick sort result:" + data[i]);
        }
    }

    static void quickSort(int a[], int l, int r) {
        if (l >= r) return;
        //先分区，找到分区点
        int pivot = partition(a, l, r);
        quickSort(a, l, pivot - 1);
        quickSort(a, pivot + 1, r);
    }

    /**
     * 分区处理思想：我们通过游标 i 把 A[p...r-1]分成两部分。A[p...i-1]的元素都是小于 pivot 的，
     * 我们暂且叫它“已处理区间”，A[i...r-1]是“未处理区间”。
     * 我们每次都从未处理的区间 A[i...r-1]中取一个元素 A[j]，与 pivot 对比，
     * 如果小于 pivot，则将其加入到已处理区间的尾部，也就是 A[i]的位置。
     */
    private static int partition(int a[], int l, int r) {
        //以最右边的元素作为pivot
        int pivot = a[r];
        int i = l;
        for (int j = i; j < r; j++) {
            if (a[j] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        int temp = a[i];
        a[i] = pivot;
        a[r] = temp;
        return r;
    }

}
