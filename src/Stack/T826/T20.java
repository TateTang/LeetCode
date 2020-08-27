package Stack.T826;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/8/26 10:01
 * @Description 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 输入: "()"
 * 输出: true
 * 这道题让我们验证输入的字符串是否为括号字符串，包括大括号，中括号和小括号。
 * 解题方法：
 * 1、遍历输入字符串
 * 2、如果当前字符为左半边括号，将其压入栈中
 * 3、如果遇到右半边括号，分类讨论：
 * 3.1、栈不为空，且与左半边括号对应，取出栈顶元素，继续循环
 * 3.2、此时栈为空，直接返回false
 * 3.2、不为对应的左半边括号，反之返回false
 */
public class T20 {
    public static void main(String[] args) {
        String s = "[";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {//栈，先进后出
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i)); //入栈
            } else {
                //遇到右半边括号的时候
                if (stack.isEmpty()) {
                    return false;//为空直接返回false
                }
                char pop = stack.pop();//栈顶元素出栈，并返回栈顶的值
                char match = 0;
                if (s.charAt(i) == ')') {
                    match = '(';
                }
                if (s.charAt(i) == '}') {
                    match = '{';
                }
                if (s.charAt(i) == ']') {
                    match = '[';
                }
                if (pop != match) {
                    return false;//不为对应的左半边括号，反之返回false，peek()只是获取栈顶的值，但是并不会把元素从栈顶弹出来。
                }
            }
        }
        return stack.isEmpty();//最后直接判断stack中是否有东西，如果没有满足有效括号，否则就是不满足有效括号
    }
}
