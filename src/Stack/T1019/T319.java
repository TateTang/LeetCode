package Stack.T1019;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/10/19 10:56 上午
 * @Description 316. 去除重复字母 给你一个字符串 s ，请你去除字符串中重复的字母，
 * 使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * <p>
 * 字典序思想
 * 字符串之间比较和数字之间比较是不一样的，字符串比较是从头往后一个字符一个字符比较的
 * 哪个字符大取决与两个字符中第一个对应不相等的字符。根据这个规则
 * 任意一个以a 开头的字符串都小于任意一个以b开头的字符串
 * 综上所述：将最小的字符尽可能的放在前面
 */
public class T319 {
    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters1(s));
    }

    public static String removeDuplicateLetters(String s) {
        /*
            方法一：
            题目要求最终返回的字符串必须包括所有出现过的字母，同时让字符串的字典序最小，因此
            对于最终返回的字符串，最左侧的字符是能保证其他字符至少出现一次情况下的最小字符
            贪心 - 一个字符一个字符处理
            每次递归中，在保证其他字符串至少出现一次的情况下，确定最小侧字符，之后再将未处理的后缀字符串继续递归处理
         */
        int pos = 0;//最左边字母的索引
        int[] cnt = new int[26];//
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            if (--cnt[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    private static String removeDuplicateLetters1(String s) {
        /*
            方法二：贪心 - 用栈
            在遍历字符串的过程中，如果字符 i 大于字符i+1，在字符 i 不是最后一次出现的情况下，删除字符 i
            用栈来存储最终返回的字符串，并维持字符串的最小字典序，每遇到一个字符，如果这个字符不存在与栈中，需要将
            该字符压入栈中，但是在压入之前，需要先将之后还会出现，并且字典序比当前字符小的栈顶字符移除，然后再将
            当前字符当前字符压入
        */
        Stack<Character> stack = new Stack<>();
        HashSet<Character> hashSet = new HashSet<>();//元素不能重复
        //这将让我们知道s中是否还有s[i]的实例
        HashMap<Character, Integer> last_occurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            last_occurrence.put(s.charAt(i), i);//元素和下标对应，元素不重复。记录每个字母的最后一个元素位置
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //这是为了只保留每个字符中的一个
            if (!hashSet.contains(c)) {
                //栈不为空 并且 当前元素小于栈顶元素，Î并且之后还会出现（最后一个元素位置大于其位置），就需要移除栈顶元素
                while (!stack.isEmpty() && c < stack.peek() && last_occurrence.get(stack.peek()) > i) {
                    hashSet.remove(stack.pop());
                }
                hashSet.add(c);
                stack.push(c);//入栈
            }
        }
        StringBuilder builder = new StringBuilder(stack.size());
        for (Character c : stack) {
            builder.append(c.charValue());
        }
        return builder.toString();//遍历输出即可
    }
}
