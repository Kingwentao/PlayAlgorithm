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

        List<String> res = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<>();

        public List<String> restoreIpAddresses(String s) {
            int len = s.length();
            if (len < 4 || len > 12) return res;

            dfs(s, 0, len, 4);
            return res;
        }

        // residue：记录剩余多少段未分割
        private void dfs(String s, int begin, int len, int residue) {
            if (begin == len) {
                if (residue == 0) {
                    // join: 把集合里的元素通过'.'拼接成字符串
                    res.add(String.join(".", deque));
                }
            }
            for (int i = begin; i < begin + 3; i++) {
                if (i >= len) break;
                // 后面的每段填满也不能用完的话，直接添加下一个
                if (residue * 3 < len - i) continue;
                if (!judgeSpliteSegment(s, begin, i)) continue;
                String curIpSegment = s.substring(begin, i + 1);
                deque.addLast(curIpSegment);
                dfs(s, i + 1, len, residue - 1);
                deque.removeLast();
            }
        }

        private boolean judgeSpliteSegment(String s, int start, int end) {
            int len = end - start + 1;
            // 0开头的超过一个的不合法
            if (len > 1 && s.charAt(start) == '0') {
                return false;
            }
            int res = 0;
            for (int i = start; i <= end; i++) {
                res = res * 10 + s.charAt(i) - '0';
            }
            return res >= 0 && res <= 255;
        }

    }

}
