package One_question_per_day;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/4/1 8:50 下午
 * @Description 1006. 笨阶乘
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。
 * 例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：
 * 乘法(*)，除法(/)，加法(+)和减法(-)。
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，
 * 这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘
 * 示例 1：
 * 输入：4
 * 输出：7
 * 解释：7 = 4 * 3 / 2 + 1
 * <p>
 * 示例 2：
 * 输入：10
 * 输出：12
 * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 */
public class T0401 {
    public static void main(String[] args) {
        //int N = 10;
        int N = 10; //7 输出6
        System.out.println(clumsy(N));
    }

    public static int clumsy(int N) {
        /*
        「笨阶乘」没有显式括号，运算优先级是先「乘除」后「加减」。我们可以从
    1 ，枚举这些数的时候，认为它们之前的操作符按照「乘」「除」「加」「减」交替进行。
    2、出现乘法、除法的时候可以把栈顶元素取出，与当前的 N进行乘法运算、除法运算（除法运算需要注意先后顺序），并将运算结果重新压入栈中；
    3、出现加法、减法的时候，把减法视为加上一个数的相反数，然后压入栈，等待以后遇见「乘」「除」法的时候取出。
    4、栈中元素想加即可求得最终结果
         */
        //使用栈来做
        Stack<Integer> stack = new Stack<>();
        stack.push(N);//当前元素直接先入栈
        N--;
        int index = 0;//控制* / + -
        while (N > 0) {
            int operator = index % 4;//取得当前运算符
            if (operator == 0) {
                stack.push(stack.pop() * N); // *
            } else if (operator == 1) {
                stack.push(stack.pop() / N); // /
            } else if (operator == 2) {
                stack.push(N); // +，直接入栈即可
            } else {
                stack.push(-N); // -，直接入栈负数即可
            }
            index++;
            N--;
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
