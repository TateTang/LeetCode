package Stack.T0911;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/9/11 10:44
 * @Description 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * 提示：
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'
 */
public class T844 {
    public static void main(String[] args) {
        String S = "a#c";
        String T = "b";
        System.out.println(backspaceCompare(S, T));
    }

    public static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
        //双指针方法
        /*
        思路：一个字符是否属于最终字符串的一部分
         */
    }

    /**
     * 重构字符串的方式， 在 build(S) 中，使用栈存储每次输入的字符。
     *
     * @param str 输入的字符串
     * @return 返回字符串
     * 时间复杂度：O(M + N)O(M+N)，其中 M, NM,N 是字符串 S 和 T 的长度。
     * 空间复杂度：O(M + N)O(M+N)。
     */
    public static String build(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch != '#') {
                stack.push(ch);//不等于 # 入栈
            } else if (!stack.isEmpty()) {
                stack.pop();//需要去掉前一个元素，也就是出栈，弹出
            }
        }
        return String.valueOf(stack);
    }
}
