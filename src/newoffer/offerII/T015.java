package newoffer.offerII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tangmf
 * @date 2022年09月22日 10:11:​30
 * 剑指 Offer II 015. 字符串中的所有变位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 变位词 指字母相同，但排列不同的字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 *  示例 2：
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
 */
public class T015 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new T015().findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        /*
            由于变位词不会改变字符串中每个字符的个数，所以只有当两个字符串每个字符的个数均相等时，一个字符串才是另一个字符串的变位词。
            1.根据这一性质，记 s 的长度为n，我们可以遍历 p 中的每个长度为n的子串，判断子串和s中每个字符的个数是否相等，若相等则说明该子串是s的一个变位词。
            2.使用两个数组 sCount 和 pCount，，sCount 统计s1中各个字符的个数，pCount 统计当前遍历的子串中各个字符的个数。
            3.由于需要遍历的子串长度均为n，我们可以使用一个固定长度为n的滑动窗口来维护 pCount：
                3.1 滑动窗口每向右滑动一次，就多统计一次进入窗口的字符，少统计一次离开窗口的字符。
                3.2然后，判断 sCount 是否与cnt2 相等，若相等则意味着s1 的变位词之一是 s2 的子串。
         */
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            // 字符串s的长度小于字符串p的长度时，字符串s中一定不存在p的变位词，特殊处理
            return ans;
        }
        //sCount 滑动窗口中每种字母的数量，cnt2统计当前遍历的子串中各个字符的个数,p是子串
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) {
            //s中各个字符的个数和p中各个字符的个数 相等直接返回即可
            ans.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            // 滑动窗口每向右滑动一次，多统计一次进入窗口的字符，少统计一次离开窗口的字符
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
