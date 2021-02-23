package com.wtk.playalgorithm.sort;

/**
 * author: created by wentaoKing
 * date: created in 2/23/21
 * description: 排序算法
 * 参考地址：https://time.geekbang.org/column/article/41802
 */
class SortMain {

    private static int[] data = {3, 5, 4, 1, 2, 6};

    public static void main(String[] args) {
//        bubbleSort();
        insertionSort();
    }

    /**
     * 冒泡排序:
     * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，
     * 看是否满足大小关系要求。如果不满足就让它俩互换
     * note: 一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
     * 1.冒泡排序是原地排序算法，冒泡的过程只涉及相邻数据的交换操作，只需要常量级的临时空间，所以它的空间复杂度为O(1)
     * 2.冒泡排序可以是稳定的排序算法，为了保证冒泡排序算法的稳定性，
     * 当有相邻的两个元素大小相等的时候，我们不做交换，相同大小的数据在排序前后不会改变顺序
     * 3.时间复杂度：最好情况下，只需要进行一次冒泡操作，最好情况时间复杂度是 O(n)
     * 最坏的情况是，要排序的数据刚好是倒序排列的，我们需要进行 n 次冒泡操作，所以最坏情况时间复杂度为O(n^2)
     * 平均时间复杂度是：O(n^2)
     */
    static void bubbleSort() {
        int n = data.length;
        //优化方法：如果在一轮冒泡排序中，没有元素发生交换，则意味着已完全排好序，直接结束即可
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("bubble sort result:" + data[i]);
        }
    }

    /**
     * 插入排序：将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有一个元素，就是数组的第一个元素。
     * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
     * 重复这个过程，直到未排序区间中元素为空，算法结束。
     * 1.插入排序算法的运行并不需要额外的存储空间，所以空间复杂度是 O(1)，也就是说，这是一个原地排序算法。
     * 2.对于值相同的元素，我们可以选择将后面出现的元素，插入到前面出现元素的后面，这样就可以保持原有的前后顺序不变，
     * 所以插入排序是稳定的排序算法。
     * 3.要排序的数据已经是有序的，我们并不需要搬移任何数据。
     * 如果我们从尾到头在有序数据组里面查找插入位置，每次只需要比较一个数据就能确定插入的位置
     * 如果数组是倒序的，每次插入都相当于在数组的第一个位置插入新的数据，所以需要移动大量的数据，
     * 所以最坏情况时间复杂度为 O(n2)。
     * 每次插入操作都相当于在数组中插入一个数据，循环执行 n 次插入操作，所以平均时间复杂度为 O(n2)。
     */
    static void insertionSort() {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            //插入的值
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < data[j]) {
                    data[j + 1] = data[j];  //移动数据
                } else {
                    break;
                }
            }
            //插入元素
            data[j + 1] = value;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("insert sort result:" + data[i]);
        }
    }

}
