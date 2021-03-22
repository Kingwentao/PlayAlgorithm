package com.wtk.playalgorithm.search;

/**
 * author: created by wentaoKing
 * date: created in 3/22/21
 * description: 二分查找法的变种：遇到重复的元素
 */
class BranchSearch2 {

    private static int a[] = {0, 1, 2, 3, 3, 3, 3, 4, 5, 5, 6};

    public static void main(String[] args) {
        int res = findFirst(a, a.length, 3);
        System.out.println("first value 3 pos index: " + res);

        int res2 = findLast(a, a.length, 3);
        System.out.println("last value 3 pos index: " + res2);

        int res3 = findFirstBig(a, a.length, 3);
        System.out.println("first big value 3 pos index: " + res3);
    }

    /**
     * 查找第一个值等于给定值的元素
     * <p>
     * 如果 mid 等于 0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的；如果 mid 不等于 0，
     * 但 a[mid]的前一个元素 a[mid-1]不等于 value，
     * 那也说明 a[mid]就是我们要找的第一个值等于给定值的元素。
     * 如果经过检查之后发现 a[mid]前面的一个元素 a[mid-1]也等于 value，
     * 那说明此时的 a[mid]肯定不是我们要查找的第一个值等于给定值的元素。那我们就更新 high=mid-1，
     * 因为要找的元素肯定出现在[low, mid-1]之间。
     */
    private static int findFirst(int a[], int n, int value) {
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] > value) {
                r = mid;
            } else if (a[mid] < value) {
                l = mid;
            } else {
                if (mid == 0 || a[mid - 1] != value) return mid;
                else r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元
     */
    private static int findLast(int a[], int n, int value) {
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] > value) {
                r = mid;
            } else if (a[mid] < value) {
                l = mid;
            } else {
                if (mid == n - 1 || a[mid + 1] != value) return mid;
                else l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    private static int findFirstBig(int a[], int n, int value) {
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] >= value) {
                //如果 a[mid]前面已经没有元素，或者前面一个元素小于要查找的值 value，那 a[mid]就是我们要找的元素。
                if (mid == 0 || a[mid - 1] < value) return mid;
                else r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
