package com.wtk.playalgorithm.sort;

/**
 * author: created by wentaoKing
 * date: created in 3/1/21
 * description: 归并排序
 */
class MergeSort {

    private static int[] data = {3, 5, 4, 1, 2, 6};

    public static void main(String[] args) {
        mergeSort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.println("select sort result:" + data[i]);
        }
    }

    //归并排序
    static void mergeSort(int data[], int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(data, left, mid);
        mergeSort(data, mid + 1, right);
        merge(data, left, mid, right);
    }

    static void merge(int data[], int left, int p, int right) {
        //初始化i,j 移动比较指针
        int i = left;
        int j = p + 1;
        int k = 0;
        //临时存储比较后的数据
        int temp[] = new int[right - left + 1];
        //通过两个指针比较分开的两部分
        while (i <= p && j <= right) {
            if (data[i] < data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }

        //判断在哪个部分没有比较完
        int start = i;
        int end = p;
        if (j <= right) {
            start = j;
            end = right;
        }

        //把未比较完的数据放到临时数组中
        while (start <= end) {
            temp[k++] = data[start++];
        }

        //把临时数据拷贝到新数组中
        for (int d = 0; d <= right - left; d++) {
            //注意这里不能直接修改left的值
            data[left] = temp[d];
        }

    }

}
