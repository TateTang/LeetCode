package hw;

import java.util.*;

/**
 * @author tangmf
 * @date 2022年09月19日 13:48:​00
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class TP139 {
    public static void main(String[] args) {
        //String s = "catsandog";
        //List<String> wordDict = new ArrayList<>();
        //wordDict.add("cats");
        //wordDict.add("dog");
        //wordDict.add("sand");
        //wordDict.add("and");
        //wordDict.add("cat");
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("apple");
        System.out.println(new TP139().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        /*动态规划：
        状态表示：dp[i] 表示字符串 s 的前i个字符是否可以拆分成wordDict，true 或者 false
        状态计算：加上当前遍历到了第 i 个字符，依据最后一次拆分成的字符串 str 划分集合，最后一次拆分成的字符串str 可以为
        s[0~i-1]，s[1~i-1]......s[j~i-1]
        状态转移方程：dp[i] = true 的条件是：dp[i]=true && s[j,i-1]在哈希表中存在
        初始化：dp[0] = true ，表示空串合法的
        实现：为了快速判断字符串 s 拆分出来的子串在 wordDict 中出现，使用哈希表存储 wordDict 中的每个word
        时间复杂度：状态枚举O(n)，状态计算O(n)，时间复杂度 O(n^2)
         *
         */
        Set<String> wordDictSet = new LinkedHashSet<>(wordDict);
        int size = s.length();
        // dp[i] 表示字符串 s 的前i个字符是否可以拆分成wordDict，true 或者 false
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;//初始化，空串合法
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {
                //遍历 s[0~i-1]，s[1~i-1]......s[j~i-1]，j：访问对前i个字符所有可能的划分，substring 左闭右开
                String substring = s.substring(j, i);
                System.out.println(substring);
                if (dp[j] && wordDictSet.contains(substring)) {
                    dp[i] = true;
                    break;//有一个方案合法就可以结束了
                }
            }
        }
        return dp[size];
    }
}
