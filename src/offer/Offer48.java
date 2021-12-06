package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tangmf
 * @Date 2021/12/6 2:28 下午
 * @Description 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Offer48 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Offer48().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        /*
        双指针 + 哈希表：滑动窗口
        哈希表dic统计：指针j 遍历字符s，哈希表统计字符s[j]最后异常出现的索引
        更新左指针：根据上轮左指针i 和 dic[s[j]]，每轮更新左边界i，保证区间[i+1,j]内无重复字符，并且最大
                - i = max(dic[s[j]],i);
        更新结果res：取上轮res 和本轮双指针区间[i+1，j]的宽度(j-i)中的最大值即可
                - res =max(res,j-i)
        复杂度分析：
        时间复杂度O(N)：其中N为字符串长度，动态规划遍历计算dp列表
        空间复杂度O(1)：字符ASCII码范围为0～127，哈希表dic最多使用O(128)=O(1)大小的额外空间
         */
        int i = -1, res = 0;//定义左指针i，//划定当前窗口的坐标为(i,j],左开右闭,所以start的初始值为-1，而非0。
        Map<Character, Integer> dic = new HashMap<>();//hash 统计各字符最后一次出现的索引位置
        for (int j = 0; j < s.length(); j++) {
            //字符在map中存在的时候，判断其索引值index和当前窗口i的大小来确定是否需要对start进行更新
            //index > i时候，i，更新为当前index，否则不变
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j)));//更新左指针
            }
            dic.put(s.charAt(j), j);// 哈希表记录：map中不含有当前值，设置值，没有新增，有就更新
            res = Math.max(res, j - i);// 更新结果：j-i，当前滑动空间(i,j]的长度，若其大于i，res，需要进行更新
        }
        return res;
    }
}
