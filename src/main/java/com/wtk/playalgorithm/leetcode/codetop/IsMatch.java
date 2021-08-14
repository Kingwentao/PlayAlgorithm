package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 8/14/21
 * description: 10.正则表达式匹配
 */
class IsMatch {

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        boolean ret = new Solution().isMatch(s, p);
        System.out.println("is match: " + ret);
    }

    static class Solution {
        public boolean isMatch(String s, String p) {
            if (s.isEmpty()) return true;
            if (p.isEmpty()) return false;
            //dp[i][j] 表示到字符串s中前i个,字符串p前j个字符是否匹配
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            //状态初始化
            dp[0][0] = true;
            for (int j = 2; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            }

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    //当前字符串是*，可以将 字符+*全部忽略掉，取f[i][j-2]的值
                    //或者看模式串P的上一个字符串是否能跟字符串S匹配
                    //如果能匹配上，可以忽略掉模式串的 字符+*，也可以忽略掉字符串S中的当前字符
                    if (p.charAt(j - 1) == '*') {
                        if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                        } else dp[i][j] = dp[i][j - 2];
                    } else {
                        // 单个字符匹配： 相同/为.
                        if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }

                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
