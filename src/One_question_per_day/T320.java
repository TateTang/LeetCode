package One_question_per_day;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/3/26 3:17 下午
 * @Description 150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 示例 1：
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：
 * 该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * 逆波兰表达式：
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 */
public class T320 {
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        //数字或者变量入栈，运算符将两个元素弹出作运算然后入栈
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") ||
                    token.equals("*") || token.equals("/")) {
                //遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
                int varA = stack.pop();//栈顶元素，后入栈的
                int varB = stack.pop();//第二栈顶元素，先入栈的
                int result = 0;
                switch (token) {
                    case "+":
                        result = varB + varA;
                        break;
                    case "-":
                        result = varB - varA;
                        break;
                    case "*":
                        result = varB * varA;
                        break;
                    case "/":
                        result = varB / varA;
                        break;
                    default:
                        break;
                }
                stack.push(result);//结果入栈
            } else {
                //遇到数字则入栈
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public int evalRPN1(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            //遇到运算符取出栈顶两个数字进行计算，将结果压入栈中
            switch (s) {
                case "+": {
                    if (!stack.isEmpty()) {
                        int pop1 = stack.pop();
                        int pop2 = stack.pop();
                        stack.push(pop1 + pop2);
                    }
                    break;
                }
                case "-": {
                    if (!stack.isEmpty()) {
                        int pop1 = stack.pop();
                        int pop2 = stack.pop();
                        stack.push(pop2 - pop1);//先入栈的减去后入栈的元素
                    }
                    break;
                }
                case "*": {
                    if (!stack.isEmpty()) {
                        int pop1 = stack.pop();
                        int pop2 = stack.pop();
                        stack.push(pop1 * pop2);
                    }
                    break;
                }
                case "/": {
                    if (!stack.isEmpty()) {
                        int pop1 = stack.pop();
                        int pop2 = stack.pop();
                        stack.push(pop2 / pop1);//倒数第二个除以栈顶元素
                    }
                    break;
                }
                default:
                    //遇到数字 入栈
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }
}
