package com.wtk.playalgorithm.leetcode.string;

/**
 * author: WentaoKing
 * created on: 4/30/21
 * description: 剑指Offer-05: 替换空格
 * 把字符串 s 中的每个空格替换成"%20"
 * <p>
 * 核心思路：扩容+双指针
 * 计算出替换后的长度，一个指针指向原数组末尾，另一指针指向结果数组末尾
 */
class ReplaceSpace {

    public static void main(String[] args) {
        String sb = "abc def";
        String res = replaceSpace(sb);
        System.out.println("replace result: " + res);
    }

    public static String replaceSpace(String s) {
        int spaceCount = 0;
        StringBuilder sb = new StringBuilder(s);
        int oldLen = sb.length();
        //计算空格数得到新数组长度
        for (int i = 0; i < oldLen; i++) {
            if (sb.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        int oldIndex = oldLen - 1;
        sb.setLength(oldLen + spaceCount * 2);
        //note: 注意使用StringBuilder时，长度的计算要用内部api，不能直接根据字符长度（oldLen + spaceCount * 2）
        int newIndex = sb.length() - 1;
        while (oldIndex != newIndex) {
            if (sb.charAt(oldIndex) == ' ') {
                sb.setCharAt(newIndex--, '0');
                sb.setCharAt(newIndex--, '2');
                sb.setCharAt(newIndex--, '%');
            } else {
                sb.setCharAt(newIndex--, sb.charAt(oldIndex));
            }
            oldIndex--;
        }
        return sb.toString();
    }

}
