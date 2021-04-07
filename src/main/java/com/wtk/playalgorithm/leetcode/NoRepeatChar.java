package com.wtk.playalgorithm.leetcode;

import java.util.HashMap;

/**
 * author: created by wentaoKing
 * date: created in 4/5/21
 * description: 无重复字符的最长字串
 * <p>
 * 思路：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
 * 滑动窗口法
 */
class NoRepeatChar {

    public static void main(String[] args) {
        //String s = "abcabcbb";
        //String s = "abba";
        String s = "pwwkewfgh";
        System.out.println("无重复字符的最长字串:" + lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        //key记录字符，value字符位置+1（表示字符所在位置后一个才开始不重复）
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            //查找过程查看表中是否存在该值，如果存在并且在它后面，则直接跳到后面去，
            // 因为start到该位置长度的最长长度已经得到，不需要（start+1）慢慢后移重复计算
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)));
            }
            map.put(s.charAt(end), end + 1);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
