package newoffer.offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmf
 * @date 2022年09月06日 09:35:​10
 * 剑指 Offer II 005. 单词长度的最大乘积
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，
 * 它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 * 示例 1:
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * <p>
 * 示例 2:
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * <p>
 * 示例 3:
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 */
public class T005 {
    public static void main(String[] args) {
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        //String[] words = {"a", "aa", "aaa", "aaaa"};
        System.out.println(new T005().maxProduct1(words));
        System.out.println(1 << 1);
        System.out.println(1 << 3);
    }

    public int maxProduct(String[] words) {
        /**
         * 循环判断，效率低下啊
         */
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String wordi = words[i];
                String wordj = words[j];
                boolean comparei = compare(wordi, wordj);
                boolean comparej = compare(wordj, wordi);
                // wordi 包含 wordj，wordj 包含 wordi，它们不包含相同字符 进行记录
                if (!(comparei && comparej)) {
                    res.add(wordi.length() * wordj.length());
                }
            }
        }
        if (res.size() <= 0) {
            return 0;
        }
        return res.stream().max(Integer::compare).get();
    }

    /**
     * 判断字符串中是否有相等字符
     *
     * @param a a
     * @param b b
     * @return ture or false
     */
    public boolean compare(String a, String b) {
        /*
         * 判断字符串是否含有重复字符：
         *     1.首先将字符串转成字符数组
         *     2.利用 indexof 与 lastindexof 判断字符是否重复
         */
        char[] chara = a.toCharArray();
        char[] charb = b.toCharArray();
        for (char value : chara) {
            for (char c : charb) {
                if (value == c) {
                    // 有相同的返回即可
                    return true;
                }
            }
        }
        return false;
    }

    public int maxProduct1(String[] words) {
        /*
        使用位运算
        为了得到单词长度的最大乘积，朴素的做法是，遍历字符串数组 words 中的每一对单词，判断这一对单词是否有公共字母，
        如果没有公共字母，则用这一对单词的长度乘积更新单词长度的最大乘积。
        用n 表示words长度，用 Li表示单词words[i]长度，其中 0<=i<n，则上述做法需要遍历字符串数组words中的每一对单词，
        对于下标为i，j的单词，其中i<j，
        判断两个单词是否有公共字母的时间复杂度降低到O(1)，可以使用位运算预处理每个单词，通过位运算判断两个单词是否有公共字母
        1.由于单词只包含小写字母，共有26个小写字母，可以使用位掩码的最低26位分别表示每个字母是否在这个单词中出现
        2.将 a 到 z 分别记为第 0个字母到第 25 个字母，则位掩码的从低到高的第 i 位是 1 当且仅当第 i 个字母在这个单词中,0 <=i <=25
        3.用数组masks 记录每个单词的位掩码表示。记录数组masks之后，判断第 i 个但是和第j个但是是否有公共字母，
        4.通过 masks[i] & masks[j] 是否等于0实现，当且仅当 masks[i] &masks[j] = 0时第 i 个单词和第 j 个单词没有公共字母，
        此时使用这两个单词的长度乘积更新单词长度的最大乘积。
         */
        int length = words.length;
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                //
                masks[i] = masks[i] | 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    //第 i 个单词和第 j 个单词没有公共字母
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }
}
