package One_question_per_day;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/5/31 10:47 上午
 * @Description 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 * 示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 解释：先反转子字符串 "love" ，然后反转整个字符串。
 * 示例 3：
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。
 */
public class T0526 {

    public static void main(String[] args) {
        String s = "(u(love)i)";
        System.out.println(new T0526().reverseParentheses(s));
    }

    public String reverseParentheses(String s) {
        /*
         * 从左到右遍历字符串，使用字符串str记录当前层遍历到的小写英文字母，对于当前遍历的字符
         * 1、如果是左括号，将str插入到栈中，str置为空，进入下一层；
         * 2、如果是右括号，则说明遍历完了当前层，需要将str进行反转，返回给上一层。
         * 将栈顶字符串弹出，然后将反转的str拼接到栈顶字符串的末尾，结果赋值给str
         * 3、如果是小写英文字母，将其添加到str末尾
         * 注意：遇到右括号的时候才进行了字符串处理，这样可以保证我们是按照从括号内到括号外的顺序处理字符串
         */
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                //存在左括号
                stack.push(builder.toString());
                builder.setLength(0);
            } else if (ch == ')') {
                //右括号的时候
                builder.reverse();
                builder.insert(0,stack.pop());
            } else {
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
