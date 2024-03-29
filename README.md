# PlayAlgorithm
learn algorithm contain note and practice algorithm question.

### 刷LeetCode题目方法or经验
（1）看完题就会做的：看看题解区的优秀题解，以防自己使用的是暴力法 

（2）看完题不会做的：看题解区的解题核心思路 -> 根据解题思路自己尝试撸码 -> 如果撸不出来、写不对 
                  -> 查看详细解题过程 -> 再次尝试自己撸代码 -> 如果依旧撸不动、撸不对
                  -> 直接查看题解区的优秀代码 -> 看完看懂后自己默写一遍
                                 
（3）同一道题多刷几遍，直到能够非常熟练的写出来

> 知识需要沉淀，不要想试图一下子掌握所有
> 在学习的过程中，一定会碰到“拦路虎”。如果哪个知识点没有怎么学懂，不要着急，这是正常的。
> 因为，想听一遍、看一遍就把所有知识掌握，这肯定是不可能的。学习知识的过程是反复迭代、不断沉淀的过程。
                               
### 常用基础知识

#### 排序
工程上，一般使用的是综合排序，会结合多种排序的不同特性，根据数据量和数据类型选择不同选择不同的排序算法。
比如，如果排序的是基本数据类型使用快排，但如果是非基本数据类型使用归并排序。这是因为归并排序具有稳定性。
而对于基本数据类型来说，稳定性无实际意义。

- 三种排序算法
- 归并排序和快速排序
- 二分查找法

### 经典题型
- 求x的平方根,精确到6位小数
- 剑指Offer-04: 二维数组中的查找
- 剑指Offer-05: 替换空格
- 剑指Offer-06: 从尾到头打印链表
- 剑指Offer-18: 删除链表的节点
- 剑指Offer-26: 树的子结构
- 剑指Offer-27: 二叉树的镜像
- 剑指Offer-30：包含min函数的栈
- 剑指Offer-31：栈的压入、弹出序列
- 剑指Offer-33：二叉搜索树的后序遍历序列
- 剑指Offer-36: 二叉搜索树与双向链表
- 剑指Offer-38：字符串的排列
- 剑指Offer-39: 数组中出现次数超过一半的数字
- 剑指Offer-40: 最小的k个数

#### 一.动态规划篇

1. 动态规划常常适用于有重叠子问题和最优子结构性质的问题，并且记录所有子问题的结果。
重叠子问题是指不同的决策序列，到达某个相同的阶段时，可能会产生重复的状态。
最优子结构指的是，问题的最优解包含子问题的最优解。反过来说就是，我们可以通过子问题的最优解，推导出问题的最优解。
2. 使用动态规划解决的问题有个明显的特点，需要满足无后效性。
无后效性有两层含义，第一层含义是，在推导后面阶段的状态的时候，我们只关心前面阶段的状态值，不关心这个状态是怎么一步一步推导出来的。
第二层含义是，某阶段状态一旦确定，就不受之后阶段的决策影响。无后效性是一个非常“宽松”的要求。
3. 动态规划只解决每个子问题一次，具有天然剪枝的功能，减少了计算量。
4. 动态规划有自底向上和自顶向下两种解决问题的方式。自顶向下即记忆化递归，自底向上就是递推。

|           题目            |               代码中类名(leetcode address)               | 
| :-----------------------: | :----------------------------------------------------------: | 
| 62.不同路径 | [UniquePaths](https://leetcode-cn.com/problems/unique-paths/) | 
|  121. 买卖股票的最佳时机    | [MaxProfit](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)| 
|  122.买卖股票的最佳时机II   |         [MaxProfit2](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/) |  
|  322.零钱兑换   |         [CoinChange](https://leetcode-cn.com/problems/coin-change/)  |

#### 二、递归与回溯篇

|           题目            |               代码中类名(leetcode address)               | 
| :-----------------------: | :----------------------------------------------------------: | 
| 17.电话号码的字母组合 | [LetterCombinations](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/) | 
|  46.全排列  |         [Permute](https://leetcode-cn.com/problems/permutations/)         |
|  47.全排列II  |         [PermuteUnique](https://leetcode-cn.com/problems/permutations-ii/)         |   
|  93.复原IP地址  |         [RestoreIpAddresses](https://leetcode-cn.com/problems/restore-ip-addresses/)   |
|  39.组合总和  |         [CombinationSum](https://leetcode-cn.com/problems/combination-sum/)         |   
|  78.子集  |         [Subsets](https://leetcode-cn.com/problems/subsets/)         |   
|  90.子集II  |         [SubsetsWithDup](https://leetcode-cn.com/problems/subsets-ii/)         |  

#### 三、数组与排序

|           题目            |               代码中类名(leetcode address)               | 
| :-----------------------: | :----------------------------------------------------------: | 
| 215.数组中的第K个最大元素 | [FindKthLargest](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/) |
| 剑指Offer-40: 最小的k个数 |             [GetLeastNumbers](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)              |  
|  912.排序数组   |         [SortArray](https://leetcode-cn.com/problems/sort-an-array/)         |  
|  88.合并两个有序数组   |         [MergeArray](https://leetcode-cn.com/problems/merge-sorted-array/)         |   

#### 四、链表

|           题目            |               代码中类名(leetcode address)               | 
| :-----------------------: | :----------------------------------------------------------: |
|  206.反转链表        |         [ReverseList](https://leetcode-cn.com/problems/reverse-linked-list/)  |  
|  2.两数相加    |         [AddTwoNumbers](https://leetcode-cn.com/problems/add-two-numbers/)    |  
|  25.K 个一组翻转链表        |         [ReverseKGroup](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)  |  
|  19.删除链表的倒数第N个结点     |         [RemoveNthFromEnd](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)  | 
|  剑指Offer22:链表中倒数第k个节点     |         [GetKthFromEnd](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)    | 
|  160. 相交链表     |         [GetIntersectionNode](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/) | 
|  21.合并两个有序链表   |         [MergeTwoLists](https://leetcode-cn.com/problems/merge-two-sorted-lists/) |   
|  142.环形链表II   |         [DetectCycle](https://leetcode-cn.com/problems/linked-list-cycle-ii/) |  
|  143.重排链表  |         [ReorderList](https://leetcode-cn.com/problems/reorder-list/) |   

#### 五、二叉树

|           题目            |               代码中类名(leetcode address)               | 
| :-----------------------: | :----------------------------------------------------------: |
|  101.对称二叉树  |         [IsSymmetric](https://leetcode-cn.com/problems/symmetric-tree/)         | 
|  102.二叉树的层序遍历  |         [LevelOrder](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)         | 
|  103.二叉树的锯齿形层序遍历        |         [ZigzagLevelOrder](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/) |  
|  199.二叉树的右视图  |         [RightSideView](https://leetcode-cn.com/problems/binary-tree-right-side-view/)         |   
|  236.二叉树的最近公共祖先    |         [LowestCommonAncestor](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/) |  

#### 六、设计类

|           题目            |               代码中类名(leetcode address)               | 
| :-----------------------: | :----------------------------------------------------------: |
|  146.LRU缓存机制  |  [LRUCache](https://leetcode-cn.com/problems/lru-cache/) |  
|  62.实现前缀树  |  [Trie](https://leetcode-cn.com/problems/QC3q1f/) |  

#### 七、数学、概率题
|           题目            |               代码中类名(leetcode address)               | 
| :-----------------------: | :----------------------------------------------------------: |
|  470.用 Rand7() 实现 Rand10()  |  [Random10](https://leetcode-cn.com/problems/implement-rand10-using-rand7/) |

#### 八、贪心算法

|           题目            |               代码中类名(leetcode address)               | 
| :-----------------------: | :----------------------------------------------------------: |
|  55.跳跃游戏  |  [CanJump](https://leetcode-cn.com/problems/jump-game/) |

### 大厂常见面试题[CodeTop](https://codetop.cc/)

**题目掌握程度标志：**
- 未掌握：⭐
- 一般： ⭐⭐
- 熟练：⭐⭐⭐

|           题目            |               代码中类名(leetcode address)               | 掌握程度 |
| :-----------------------: | :----------------------------------------------------------: | :------: |
| 215.数组中的第K个最大元素 | [FindKthLargest](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/) |    ⭐⭐⭐    |
| 剑指Offer-40: 最小的k个数 |             [GetLeastNumbers](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)              |    ⭐⭐⭐    |
|  912.排序数组   |         [SortArray](https://leetcode-cn.com/problems/sort-an-array/)         |   ⭐⭐  |
|  33.搜索旋转排序数组   |         [SearchRotateSortArray](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)         |   ⭐  |
|  41.缺失的第一个正数   |         [FirstMissingPositive](https://leetcode-cn.com/problems/first-missing-positive/)         |   ⭐  |
|  88.合并两个有序数组   |         [MergeArray](https://leetcode-cn.com/problems/merge-sorted-array/)         |   ⭐  |
|  56.合并区间   |         [MergeInterval](https://leetcode-cn.com/problems/merge-intervals/submissions/)         |   ⭐  |
|  3.无重复字符的最长子串   |         [LengthOfLongestSubstring](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)         |    ⭐     |
|  4.寻找两个正序数组的中位数   |         [FindMedianSortedArrays](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)         |    ⭐     |
|  206.反转链表        |         [ReverseList](https://leetcode-cn.com/problems/reverse-linked-list/)         |   ⭐⭐⭐    |
|  92.反转链表II  |         [ReverseBetween](https://leetcode-cn.com/problems/reverse-linked-list-ii/)         |   ⭐  |
|  2.两数相加    |         [AddTwoNumbers](https://leetcode-cn.com/problems/add-two-numbers/)         |   ⭐⭐⭐  |
|  25.K 个一组翻转链表        |         [ReverseKGroup](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)         |   ⭐⭐   |
|  剑指Offer22:链表中倒数第k个节点     |         [GetKthFromEnd](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)         |   ⭐⭐⭐  |
|  160.相交链表     |         [GetIntersectionNode](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)         |   ⭐⭐⭐  |
|  19.删除链表的倒数第N个结点     |         [RemoveNthFromEnd](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)         |   ⭐  |
|  21.合并两个有序链表   |         [MergeTwoLists](https://leetcode-cn.com/problems/merge-two-sorted-lists/)         |   ⭐⭐⭐  |
|  23.合并K个升序链表   |         [MergeKLists](https://leetcode-cn.com/problems/merge-k-sorted-lists/)         |   ⭐  |
|  142.环形链表II   |         [DetectCycle](https://leetcode-cn.com/problems/linked-list-cycle-ii/)         |   ⭐⭐  |
|  143.重排链表  |         [ReorderList](https://leetcode-cn.com/problems/reorder-list/)         |   ⭐⭐  |
|  148.排序链表  |         [SortList](https://leetcode-cn.com/problems/sort-list/)         |   ⭐  |
|  234.回文链表  |         [IsPalindrome](https://leetcode-cn.com/problems/palindrome-linked-list/)         |   ⭐⭐⭐  |
|  82.删除排序链表中的重复元素II  |         [DeleteDuplicate](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/)         |   ⭐  |
|  15.三数之和        |         [ThreeSum](https://leetcode-cn.com/problems/3sum/)         |   ⭐⭐⭐   |
|  146.LRU缓存机制        |         [LRUCache](https://leetcode-cn.com/problems/lru-cache/)         |   ⭐   |
|  1.两数之和    |         [TwoSum](https://leetcode-cn.com/problems/two-sum/)         |   ⭐⭐⭐  |
|  98.验证二叉搜索树   |         [IsValidBST](https://leetcode-cn.com/problems/validate-binary-search-tree/)         |   ⭐  |
|  剑指Offer54:二叉搜索树的第k大节点   |         [SearchTreeKthLargest](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)         |   ⭐  |
|  958.二叉树的完全性检验   |         [IsCompleteTree](https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/)         |   ⭐  |
|  101.对称二叉树  |         [IsSymmetric](https://leetcode-cn.com/problems/symmetric-tree/)         |   ⭐  |
|  102.二叉树的层序遍历  |         [LevelOrder](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)         |   ⭐⭐⭐  |
|  103.二叉树的锯齿形层序遍历        |         [ZigzagLevelOrder](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)         |   ⭐⭐  |
|  104.二叉树的最大深度        |         [MaxDepth](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)         |   ⭐  |
|  199.二叉树的右视图  |         [RightSideView](https://leetcode-cn.com/problems/binary-tree-right-side-view/)         |   ⭐⭐⭐  |
|  236.二叉树的最近公共祖先    |         [LowestCommonAncestor](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)         |   ⭐  |
|  105.从前序与中序遍历序列构造二叉树    |         [BuildTree](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)         |   ⭐  |
|  129.求根节点到叶节点数字之和    |         [SumNumbers](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)         |   ⭐  |
|  415.字符串相加   |         [AddStrings](https://leetcode-cn.com/problems/add-strings/)         |   ⭐⭐⭐  |
|  155.最小栈   |         [MinStack](https://leetcode-cn.com/problems/min-stack/)         |   ⭐⭐  |
|  232.用栈实现队列   |         [MyQueue](https://leetcode-cn.com/problems/implement-queue-using-stacks/)         |   ⭐⭐⭐  |
|  54.螺旋矩阵   |         [SpiralOrder](https://leetcode-cn.com/problems/spiral-matrix/)         |   ⭐  |
|  200.岛屿数量   |         [NumIslands](https://leetcode-cn.com/problems/number-of-islands/)         |   ⭐⭐  |
|  31.下一个排列  |         [NextPermutation](https://leetcode-cn.com/problems/next-permutation/)         |   ⭐  |
|  46.全排列  |         [Permute](https://leetcode-cn.com/problems/permutations/)         |   ⭐  |
|  47.全排列II  |         [PermuteUnique](https://leetcode-cn.com/problems/permutations-ii/)         |   ⭐  |
|  93.复原IP地址  |         [RestoreIpAddresses](https://leetcode-cn.com/problems/restore-ip-addresses/)         |   ⭐  |
|  39.组合总和  |         [CombinationSum](https://leetcode-cn.com/problems/combination-sum/)         |   ⭐  |
|  78.子集  |         [Subsets](https://leetcode-cn.com/problems/subsets/)         |   ⭐⭐  |
|  90.子集II  |         [SubsetsWithDup](https://leetcode-cn.com/problems/subsets-ii/)         |   ⭐  |
|  20.有效的括号  |         [isValidBrackets](https://leetcode-cn.com/problems/valid-parentheses/)         |   ⭐⭐  |
|  112.路径总和 |         [HasPathSum](https://leetcode-cn.com/problems/path-sum/)         |   ⭐⭐  |
|  113.路径总和II  |         [PathSum](https://leetcode-cn.com/problems/path-sum-ii/)         |   ⭐  |
|  69.x的平方根   |         [MySqrt](https://leetcode-cn.com/problems/sqrtx/)         |   ⭐  |
|  162.寻找峰值   |         [FindPeakElement](https://leetcode-cn.com/problems/find-peak-element/)         |   ⭐  |
|  70.爬楼梯  |         [ClimbStairs](https://leetcode-cn.com/problems/climbing-stairs/)         |   ⭐⭐  |
|  5.最长回文子串  |         [LongestPalindrome](https://leetcode-cn.com/problems/longest-palindromic-substring/)         |   ⭐  |
|  10.正则表达式匹配  |         [IsMatch](https://leetcode-cn.com/problems/regular-expression-matching/)         |   ⭐  |
|  121.买卖股票的最佳时机    |         [MaxProfit](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)         |   ⭐⭐⭐  |
|  122.买卖股票的最佳时机II   |         [MaxProfit2](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)         |   ⭐⭐⭐  |
|  322.零钱兑换   |         [CoinChange](https://leetcode-cn.com/problems/coin-change/)         |   ⭐  |
|  221.最大正方形   |         [MaximalSquare](https://leetcode-cn.com/problems/maximal-square/)         |   ⭐  |
|  42.接雨水    |         [CatchRain](https://leetcode-cn.com/problems/trapping-rain-water/)         |   ⭐  |
|  53.最大子序和    |         [MaxSubArray](https://leetcode-cn.com/problems/maximum-subarray/)         |   ⭐⭐  |
|  300.最长递增子序列  |         [LengthOfLIS](https://leetcode-cn.com/problems/longest-increasing-subsequence/)         |   ⭐  |
|  1143.最长公共子序列  |         [LongestCommonSubsequence](https://leetcode-cn.com/problems/longest-common-subsequence/)         |   ⭐  |
|  32.最长有效括号  |         [LongestValidParentheses](https://leetcode-cn.com/problems/longest-valid-parentheses/)         |   ⭐  |
|  494.目标和  |         [FindTargetSumWays](https://leetcode-cn.com/problems/target-sum/)         |   ⭐  |
|  8.字符串转换整数 (atoi)  |         [MyAtoi](https://leetcode-cn.com/problems/string-to-integer-atoi/)         |   ⭐  |
|  470.用 Rand7() 实现 Rand10()  |  [Random10](https://leetcode-cn.com/problems/implement-rand10-using-rand7/) |  ⭐  |
|  43.字符串相乘  |  [StringMultiply](https://leetcode-cn.com/problems/multiply-strings/) |  ⭐  |
|  151.翻转字符串里的单词  |  [ReverseWord](https://leetcode-cn.com/problems/reverse-words-in-a-string/) |  ⭐  |
|  678.有效的括号字符串  |  [CheckValidString](https://leetcode-cn.com/problems/valid-parenthesis-string/) |  ⭐  |
|  442.数组中重复的数据  |  [FindDuplicates](https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/) |  ⭐  |
