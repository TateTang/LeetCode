package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tangmf
 * @Date 2021/8/19 11:45 上午
 * @Description 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 */
public class Offer50 {
    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(new Offer50().firstUniqChar(s));
    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();//存储当前字符出现的次数
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //遍历hash
        for (char c : chars) {
            if (map.get(c) == 1) {
                return c;//找到直接返回
            }
        }
        return ' ';
    }
}
