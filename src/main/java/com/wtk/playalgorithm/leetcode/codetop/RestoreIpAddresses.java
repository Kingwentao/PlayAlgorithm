package com.wtk.playalgorithm.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 8/8/21
 * description: 93.复原IP地址
 */
class RestoreIpAddresses {

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> ret = new Solution().restoreIpAddresses(s);
        System.out.println(ret);
    }

    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            int len = s.length();
            List<String> ret = new ArrayList<>();
            if (len < 4 || len > 12) {
                return ret;
            }
            Deque<String> deque = new ArrayDeque<>();
            dfs(s, 0, len, 4, ret, deque);
            return ret;
        }

        //residue：记录剩余多少段未分割
        private void dfs(String s, int begin, int len, int residue,
                         List<String> ret, Deque<String> path) {
            if (begin == len) {
                if (residue == 0) {
                    // join: 把集合里的元素通过'.'拼接成字符串
                    ret.add(String.join(".", path));
                }
                return;
            }
            for (int i = begin; i < begin + 3; i++) {
                if (i >= len) break;
                // 后面的每段填满也不能用完的话，直接添加下一个
                if (residue * 3 < len - i) continue;
                if (judgeSpliteSegment(s, begin, i)) {
                    String curIpSegment = s.substring(begin, i + 1);
                    path.addLast(curIpSegment);
                    dfs(s, i + 1, len, residue - 1, ret, path);
                    path.removeLast();
                }
            }
        }

        private boolean judgeSpliteSegment(String s, int left, int right) {
            int len = right - left + 1;
            // 0开头的超过一个的不合法
            if (len > 1 && s.charAt(left) == '0') {
                return false;
            }
            int res = 0;
            for (int i = left; i <= right; i++) {
                res = res * 10 + s.charAt(i) - '0';
            }
            return res >= 0 && res <= 255;
        }

    }

}
