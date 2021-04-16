package com.wtk.playalgorithm.leetcode.array;

import java.util.Arrays;

/**
 * author: created by wentaoKing
 * date: created in 4/16/21
 * description: 斐波那契数列
 */
class FibNumber {

    static int[] memo;

    public static void main(String[] args) {
        int n = 6;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int res = fib(n);
        System.out.println("fib result1:" + res);

        int res2 = fib2(45);
        System.out.println("fib result2:" + res2);

    }

    /**
     * 递归+记忆化搜索，自顶向下
     */
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] == -1) {
            memo[n] = fib(n - 1) + fib(n - 2);
        }
        return memo[n];
    }

    /**
     * 动态规划，自底向上求解
     */
    public static int fib2(int n) {
        if (n == 0) return 0;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
