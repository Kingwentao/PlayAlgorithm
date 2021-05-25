package com.wtk.playalgorithm.leetcode.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 5/24/21
 * description: 剑指Offer-38：字符串的排列
 */
class Permutation {

    static char[] c;
    static List<String> res = new LinkedList<>();

    public static void main(String[] args) {
        String s = "abc";
        String[] ret = permutation(s);
        for (String s1 : ret) {
            System.out.println("permutation result: " + s1);
        }
    }

    public static String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    public static void dfs(int x) {
        //终止条件：len - 1
        if (x == c.length - 1) {
            //note: 一次交换结束，存储它
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        //递归参数：i
        //递推工作：去重复字符 -> 交换并固定字符 -> 下层递归 -> 还原交换
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    static void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
