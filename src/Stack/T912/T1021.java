package Stack.T912;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/9/12 10:17
 * @Description 1021. 删除最外层的括号
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * 示例 1：
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * <p>
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * <p>
 */
public class T1021 {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));

    }
    private static String removeOuterParentheses(String S) {
         /*
        (单调栈解法，它的单调性在于：栈里面只存在左括号，右括号仅仅是用来消灭左括号的)
        栈的解法也非常好理解，碰到 "(" 就入栈，碰到 ")" 就把栈顶的一个 "(" 弹出。
        如果栈为空，那么刚刚碰到的 “)” 就是最外层右括号；如果入栈前栈为空，则即将入栈的 “(” 就是最外层左括号。
        */
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                if (!stack.isEmpty()) {
                    builder.append(ch);//判断是非外层括号，左括号加入前，栈不为空，拼接字符串
                }
                stack.push(ch);//左括号入栈
            }
            if (ch == ')') {
                stack.pop();//右括号出栈
                if (!stack.isEmpty()) {
                    builder.append(ch);//判断是非外层括号，右括号加入并且消除右括号之后，拼接字符串
                }
            }
        }
        return builder.toString();
    }
}
