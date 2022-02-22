package com.wtk.playalgorithm.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 2022/2/22
 * description: 获取小写字母组成的字符串的所有不重复的排序组合
 */
class ChildString {

    public static void main(String[] args) {
        String s = "aabc";
        List<String> res = new Solution().getAllChildString(s);
        System.out.println(res);
    }

    static class Solution {
        List<String> getAllChildString(String s) {
            char[] chars = s.toCharArray();
            List<String> res = new ArrayList<>();
            process(chars, 0, res);
            return res;
        }

        void process(char[] cs, int i, List<String> res) {
            if (i == cs.length) res.add(String.valueOf(cs));
            // 记录拜访过的，后面直接剪枝
            boolean[] visited = new boolean[26];
            for (int j = i; j < cs.length; j++) {
                if (!visited[cs[j] - 'a']) {
                    visited[cs[j] - 'a'] = true;
                    swap(cs, i, j);
                    process(cs, i + 1, res);
                    swap(cs, i, j);
                }
            }
        }

        void swap(char[] cs, int i, int j) {
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
        }
    }
}
