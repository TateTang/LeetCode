package newoffer.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangmf
 * @date 2022年09月22日 10:39:​27
 * 剑指 Offer II 016. 不含重复字符的最长子字符串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 */
public class T016 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new T016().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
         /*
        双指针 + 哈希表：滑动窗口
        哈希表dic统计：指针j 遍历字符s，哈希表统计字符s[j]最后一次出现的索引
        更新左指针：根据上轮左指针i 和 dic[s[j]]，每轮更新左边界i，保证区间[i+1,j]内无重复字符，并且最大
                - i = max(dic[s[j]],i);
        更新结果res：取上轮res 和本轮双指针区间[i+1，j]的宽度(j-i)中的最大值即可
                - res =max(res,j-i)
        复杂度分析：
        时间复杂度O(N)：其中N为字符串长度，动态规划遍历计算dp列表
        空间复杂度O(1)：字符ASCII码范围为0～127，哈希表dic最多使用O(128)=O(1)大小的额外空间
         */
        //定义左指针i，当前窗口(i,j],start 初始位置为i=-1
        int i = -1, res = 0;
        Map<Character, Integer> dic = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            //字符串在map 中存在的时候，判断索引值index和当前窗口i的大小确定是否需要对start进行更新
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j)));//更新左指针
            }
            //哈希表统计字符s[j]最后一次出现的索引
            dic.put(s.charAt(j), j);
            //更新结果，当前滑动空间(i,j]长度，大于res,需要进行更新
            res = Math.max(res, j - i);
        }
        return res;
    }
}
