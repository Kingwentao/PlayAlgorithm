package com.wtk.playalgorithm.leetcode.codetop;

/**
 * author: created by wentaoKing
 * date: created in 2021/10/10
 * description: 470.用 Rand7() 实现 Rand10()
 */
class Random10 {

    class Solution  {
        public int rand10() {
            while (true){
                int res;
                int a = rand7();
                int b = rand7();
                // 使用(a - 1) * 7 + b 是为了保证1-49随机树是等概率的
                // 为啥是这样做是等概率的，配合该题解理解：
                // https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/cong-zui-ji-chu-de-jiang-qi-ru-he-zuo-dao-jun-yun-/
                res = (a - 1) * 7 + b; //1-49
                if(res <= 40) return res % 10 + 1;

                a = res - 40; // 1-9
                b = rand7();
                res = (a - 1) * 7 + b; // 1-63
                if(res <= 60) return res % 10 + 1;

                a = res - 60; // 1-3
                b = rand7();
                res = (a - 1) * 7 + b; // 1-21
                if(res <= 20) return res % 10 + 1;
            }
        }

        // 随机生成7
        private int rand7(){
            return 1;
        }

    }

}
