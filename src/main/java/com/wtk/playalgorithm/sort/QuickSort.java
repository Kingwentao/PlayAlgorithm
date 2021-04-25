package com.wtk.playalgorithm.sort;

/**
 * author: created by wentaoKing
 * date: created in 3/6/21
 * description: 快速排序: 它的处理过程是由上到下的，先分区，然后再处理子问题
 * 快速排序通过设计巧妙的原地分区函数，可以实现原地排序，解决了归并排序占用太多内存的问题。
 */
class QuickSort {

    private static int[] data = {6, 11, 3, 9, 8, 15, 0, 1};

    public static void main(String[] args) {

        //快速排序
//        quickSort(data, 0, data.length - 1);
//        for (int i = 0; i < data.length; i++) {
//            System.out.println("quick sort result:" + data[i]);
//        }

        //寻找第k大元素
        int kMax = findKMaxValue(3);
        System.out.println("k max value:" + kMax);
    }

    static void quickSort(int a[], int l, int r) {
        if (l >= r) return;
        //先分区，找到分区点
//        int pivot = partition(a, l, r);
        int pivot = partition3(a, l, r);
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
        a[i] = a[r];
        a[r] = temp;
        return i;
    }

    /**
     * 三数取中法优化分区：以数组中间的点作为分区点
     * 优化点：对于已排好序的数组，如果把数组最右边点作为pivot，会将时间复杂度由O(nlgN)变为O(n^2)
     * 三数取中法、随机数法都可以避免此问题
     */
    private static int partition3(int a[], int l, int r) {
        int middle = l + (r - l) / 2;
        //先交换middle和right的值，再
        int temp = a[r];
        a[r] = a[middle];
        a[middle] = temp;
        int pivot = a[r];
        int i = l;
        for (int j = i; j < r; j++) {
            if (a[j] < pivot) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
            }
        }
        int t = a[i];
        a[i] = a[r];
        a[r] = t;
        return i;
    }


    /**
     * 寻找第k大的元素
     * 核心思想：利用快速排序中的分区思想，每次分区都可以将区域分成原有的1/2
     * 分区后pivot的位置就是最终排好序的位置，所以分区前每次把数组的最后一位定为pivot
     * 这样不断二分，当达到p+1=k的条件时，此时的pivot位置的值就是第k大的元素
     * <p>
     * 时间复杂度：如果我们把每次分区遍历的元素个数加起来，就是：n+n/2+n/4+n/8+...+1。这是一个等比数列求和，
     * 最后的和等于 2n-1。所以，时间复杂度就为 O(n)。
     */
    private static int findKMaxValue(int k) {
        if (k > data.length - 1) return -1;
        int p = partition2(data, 0, data.length - 1);
        while (true) {
            if (p + 1 == k) {
                return data[p];
            }
            p = partition2(data, 0, p - 1);
        }
    }

    private static int partition2(int a[], int l, int r) {
        //以最右边的元素作为pivot
        int pivot = a[r];
        int i = l;
        for (int j = i; j < r; j++) {
            if (a[j] > pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        int temp = a[r];
        a[r] = a[i];
        a[i] = temp;
        return r;
    }

}
