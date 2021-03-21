package com.wtk.playalgorithm.search;

import static java.lang.Math.abs;

/**
 * author: created by wentaoKing
 * date: created in 3/21/21
 * description: 二分查找算法
 * <p>
 * 二分查找的时间复杂度是 O(logn)，查找数据的效率非常高。但它的应用场景是有很大局限性的。
 * 1.首先，二分查找依赖的是顺序表结构，简单点说就是数组.主要原因是二分查找算法需要按照下标随机访问元素。
 * 数组按照下标随机访问数据的时间复杂度是 O(1)，而链表随机访问的时间复杂度是 O(n)。
 * 所以，如果数据使用链表存储，二分查找的时间复杂就会变得很高。
 * <p>
 * 2.二分查找针对的是有序数据。二分查找对这一点的要求比较苛刻，数据必须是有序的。如果数据没有序，我们需要先排序。
 * 可以进行一次排序，多次二分查找。这样排序的成本可被均摊，二分查找的边际成本就会比较低。
 * 如果我们的数据集合有频繁的插入和删除操作，要想用二分查找，要么每次插入、删除操作之后保证数据仍然有序，
 * 要么在每次二分查找之前都先进行排序。针对这种动态数据集合，无论哪种方法，维护有序的成本都是很高的。
 * <p>
 * 3.数据量太小不适合二分查找。如果要处理的数据量很小，完全没有必要用二分查找，顺序遍历就足够了。
 * 不过，这里有一个例外。如果数据之间的比较操作非常耗时，不管数据量大小，我都推荐使用二分查找。
 * 我们需要尽可能地减少比较次数，而比较次数的减少会大大提高性能，这个时候二分查找就比顺序遍历更有优势。
 * <p>
 * 4.数据量太大也不适合二分查找。二分查找的底层需要依赖数组这种数据结构，而数组为了支持随机访问的特性，
 * 要求内存空间连续，对内存的要求比较苛刻。比如，我们有 1GB 大小的数据，如果希望用数组来存储，那就需要 1GB 的连续内存空间。
 * <p>
 * ps:虽然大部分情况下，用二分查找可以解决的问题，用散列表、二叉树都可以解决。
 * 但是,不管是散列表还是二叉树，都会需要比较多的额外的内存空间。
 * 二分查找底层依赖的是数组，除了数据本身之外，不需要额外存储其他信息，是最省内存空间的存储方式，
 */
class BranchSearch {


    static int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 100};

    public static void main(String[] args) {
        int res = bSearch(a, a.length, 0);
        System.out.println("search finish: " + res);

        double x = 11, precision = 0.000001;
        double res2 = findSquareCount(x, precision);
        System.out.println("find square count result: " + res2);
    }

    private static int bSearch(int a[], int n, int value) {
        int r = n - 1;
        int l = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
//            int mid = l + ((r -l) >> 1); //位运算更快
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 求一个数的平方根，要求精确到小数点后 6 位
     * 使用二分法
     */
    private static double findSquareCount(double x, double precision) {
        if (x < 0) return -1;
        double low = 1, up = x;
        if (x > 0 && x < 1) {
            low = x;
            up = 1;
        }
        while (low <= up) {
            double mid = low + (up - low) / 2.0;
            if (abs(mid * mid - x) <= precision) {
                return mid;
            } else if (mid * mid > x) {
                up = mid;
            } else if (mid * mid < x) {
                low = mid;
            }
        }
        return -1;
    }


}
