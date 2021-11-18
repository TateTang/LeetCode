package offer;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/11/17 6:22 下午
 * @Description 剑指 Offer 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class Offer31 {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 1, 2};
        System.out.println(new Offer31().validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        /*
        借用一个辅助栈stack，模拟入栈/出栈操作。根据是否模拟成功，可以得到结果
        - 入栈操作：按照压栈序列的顺序执行
        - 出栈操作：每次入栈后，循环判断"栈顶元素=弹出序列的当前元素"是否成立，将符合弹出序列顺序的栈顶元素弹出
        题目规定：数字都不想等，入栈的时候，每个元素出栈的位置可能性是唯一的。因此，遇到栈顶元素=弹出元素，执行出栈

        流程：
        - 1、初始化：辅助栈stack，弹出序列的索引i
        - 2、遍历压栈序列,各元素记为 num ；
            - 元素num入栈
            - 循环出栈，stack的栈顶元素=弹出元素poped[i]，出栈i++
        - 3、返回值：stack是否为空
         */
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);//入栈
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                //相等的时候出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
