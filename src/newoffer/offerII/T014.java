package newoffer.offerII;

import java.util.Arrays;

/**
 * @author tangmf
 * @date 2022年09月14日 09:27:​57
 * 剑指 Offer II 014. 字符串中的变位词
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * 示例 1：
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例 2：
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
public class T014 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(new T014().checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        /*
            由于变位词不会改变字符串中每个字符的个数，所以只有当两个字符串每个字符的个数均相等时，一个字符串才是另一个字符串的变位词。
            1.根据这一性质，记 S1 的长度为n，我们可以遍历 s2 中的每个长度为n的子串，判断子串和S1中每个字符的个数是否相等，若相等则说明该子串是S1的一个变位词。
            2.使用两个数组 cnt1 和 cnt2，，cnt1 统计s1中各个字符的个数，cnt2 统计当前遍历的子串中各个字符的个数。
            3.由于需要遍历的子串长度均为n，我们可以使用一个固定长度为n的滑动窗口来维护 cnt2：
                3.1 滑动窗口每向右滑动一次，就多统计一次进入窗口的字符，少统计一次离开窗口的字符。
                3.2然后，判断 cnt1 是否与cnt2 相等，若相等则意味着s1 的变位词之一是 s2 的子串。
         */
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        //cnt1统计s1中各个字符的个数，cnt2统计当前遍历的子串中各个字符的个数
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            //s1中各个字符的个数和s2中各个字符的个数 相等直接返回即可
            return true;
        }
        for (int i = n; i < m; i++) {
            // 滑动窗口每向右滑动一次，多统计一次进入窗口的字符，少统计一次离开窗口的字符
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
