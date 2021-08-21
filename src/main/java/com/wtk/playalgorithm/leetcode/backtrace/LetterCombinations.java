package com.wtk.playalgorithm.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * author: created by wentaoKing
 * date: created in 8/21/21
 * description: 17.电话号码的字母组合
 */
class LetterCombinations {

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = new Solution().letterCombinations(digits);
        System.out.println(res);
    }

    static class Solution {

        String[] letterMap = {"", "*", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() <= 0) return res;
            StringBuilder sb = new StringBuilder();
            iterString(digits, 0 , sb);
            return res;
        }

        void iterString(String digits, int index, StringBuilder sb){
            if (index == digits.length()){
                res.add(sb.toString());
                System.out.println("得到结果 " + index + ":" + sb.toString());
                return;
            }
            char c = digits.charAt(index);
            int pos = c - '0';
            String letter = letterMap[pos];
            for (int i = 0; i < letter.length(); i++){
                sb.append(letter.charAt(i));
                System.out.println("递归前: " + sb.toString());
                iterString(digits, index + 1, sb);
                System.out.println("递归后: " + sb.toString());
                sb.deleteCharAt(sb.length() - 1);
                System.out.println("回溯: " + sb.toString());
            }
        }
    }

}
