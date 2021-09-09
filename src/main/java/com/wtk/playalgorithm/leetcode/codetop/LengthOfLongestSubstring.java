package com.wtk.playalgorithm.leetcode.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * author: created by wentaoKing
 * date: created in 6/24/21
 * description: 3.无重复字符的最长子串
 */
class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s0 = "abcabcbb";
        String s1 = "bbbbb";
        String s2 = "pwwkew";
        String s3 = "";
        int len = lengthOfLongestSubstring(s3);
        System.out.println("ret: " + len);
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        // value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
        Map<Character, Integer> record = new HashMap<>();
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            if (record.containsKey(c)) {
                start = Math.max(record.get(c), start);
            }
            max = Math.max(max, end - start + 1);
            // note: 加1的目的
            record.put(c, end + 1);
        }
        return max;
    }

}
