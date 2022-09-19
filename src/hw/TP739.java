package hw;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author tangmf
 * @date 2022年09月19日 14:08:​09
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 */
public class TP739 {
    public static void main(String[] args) {
        //int[] temperatures = {30, 40, 50, 60};
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new TP739().dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        // 定义栈来处理，栈顶完成
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            //stack.peek()，栈顶存放每一天温度的下标，取出进行比较，如果大于就求的下标差值
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int[] days = new int[temperatures.length];
        //过几天温度会升高
        for (int i = 0; i < temperatures.length; i++) {
            days[i] = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                //暴力法破解，两次比较，大于计算其差值，并且跳出当前j循环
                if (temperatures[j] > temperatures[i]) {
                    days[i] = j - i;
                    break;
                }
            }
        }
        return days;
    }
}
