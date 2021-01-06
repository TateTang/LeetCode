package Stack.T1119;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/11/19 下午2:40
 * @Description 给你一个由大小写英文字母组成的字符串 s 。
 * <p>
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 * <p>
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * <p>
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * <p>
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 * 示例 2：
 * <p>
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 */
public class T1544 {
    public static void main(String[] args) {
        String s = "leEeabBAcCetcode";
        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty()) {
                //大小写字母差为32，栈顶元素和单个元素比较
                if (Math.abs(stack.peek() - ch) == 32) {
                    stack.pop();//出栈
                    continue;//跳出本次循环
                }
            }
            stack.push(ch);
        }
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public static String makeGood1(String s) {
        /*
        从左到右扫描字符串s的内容。扫描中 维护好当前整理好的字符串，记为ret。当扫描到字符ch时，两种情况
        如果：字符ch 和ret最后一个字符互为大小写字母，根据题意，两个字符都要在整理的过程种被删除掉，因此需要弹出最后一个ret的字符
        否则：两个字符都需要保留，因此需要将字符ch附加在字符串ret的后面
         */
        StringBuilder ret = new StringBuilder();
        int retIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ret.length() > 0 && Character.toLowerCase(ret.charAt(retIndex)) ==
                    Character.toLowerCase(ch) && ret.charAt(retIndex) != ch) {
                ret.deleteCharAt(retIndex);
                retIndex--;
            } else {
                ret.append(ch);
                retIndex++;
            }
        }
        return ret.toString();
    }
}
