package newoffer.offerII;

import java.util.*;

/**
 * @author tangmf
 * @date 2022年09月04日 10:09:​16
 * 剑指 Offer II 032. 有效的变位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 * 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: s = "a", t = "a"
 * 输出: false
 */
public class T032 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        //System.out.println(new T032().isAnagram(s, t));
        //System.out.println(new T032().isAnagram1(s, t));
        //System.out.println(new T032().isAnagram2(s, t));
        System.out.println(new T032().isAnagram3(s, t));
    }

    public boolean isAnagram(String s, String t) {
        // 字符出现次数相同，出现顺序不完全相同
        // 使用hash 集合 存储出现次数，出现位置
        Map<Character, Integer> sCountMap = new HashMap<>();
        Map<Character, List<Integer>> sPositionMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // 次数map 赋值
            sCountMap.put(s.charAt(i), sCountMap.getOrDefault(s.charAt(i), 0) + 1);
            // 位置map 赋值
            List<Integer> list;
            if (sPositionMap.containsKey(s.charAt(i))) {
                list = sPositionMap.get(s.charAt(i));
                list.add(i);
            } else {
                list = new ArrayList<>();
                list.add(i);
            }
            sPositionMap.put(s.charAt(i), list);
        }
        Map<Character, Integer> tCountMap = new HashMap<>();
        Map<Character, List<Integer>> tPositionMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            // 次数map 赋值
            tCountMap.put(t.charAt(i), tCountMap.getOrDefault(t.charAt(i), 0) + 1);
            // 位置map 赋值
            List<Integer> list;
            if (tPositionMap.containsKey(t.charAt(i))) {
                list = tPositionMap.get(t.charAt(i));
                list.add(i);
            } else {
                list = new ArrayList<>();
                list.add(i);
            }
            tPositionMap.put(t.charAt(i), list);
        }
        return sCountMap.equals(tCountMap) && !sPositionMap.equals(tPositionMap);
    }

    public boolean isAnagram1(String s, String t) {
        /*
        每个字符出现的次数都相同且字符顺序不完全相同
        等价于「两个字符串不相等且两个字符串排序后相等」
        时间复杂度：O(nlogN)
        空间复杂度：O(logN)
         */
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean isAnagram2(String s, String t) {
        /*
        只针对小写字母的情况
        进阶哈希表解法:「两个字符串不相等且两个字符串中字符出现的种类和次数均相等」
        1. s和t 是否相等，相等返回false
        2. 比较字符出现的种类和次数是否相等
        3. 由于字符串只包含 2626 个小写字母，因此我们可以维护一个长度为 26 的频次数组
        4. 先遍历记录字符串 s 中字符出现的频次，然后遍历字符串 t，减去 table 中对应的频次，
        5. 如果出现 table[i]<0，则说明 t 包含一个不在 s 中的额外字符，返回 false 即可
         */
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        // 字符出现的次数
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // 字符频次数组
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            //减去table 中对应字符的频次
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                // t 包含一个不在s 中的额外字符，返回 false 即可
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        // 字符出现次数相同，出现顺序不完全相同使用hash 集合 存储出现次数
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // 次数map 赋值
            char ch = s.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            // t中如果有次数，那么需要进行相应频次
            char ch = t.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) - 1);
            // 当前字符频次 < 0直接返回
            if (countMap.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
