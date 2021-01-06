package Stack.T0106;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/1/6 4:05 下午
 * @Description 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
public class MinStack {
    //定义两个栈，A为数据栈，B为辅助栈，B存储的是A中的所有非严格降序，A栈中最小元素始终对应B中的栈顶元素
    Stack<Integer> A, B;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);//元素全部进入A栈中
        //B栈为空 或者，x小于B的栈顶元素进入B栈中，
        if (B.isEmpty() || x <= B.peek()) {
            B.push(x);
        }
    }

    public void pop() {
        //A中出栈的元素等于B中的栈顶元素也就是最小值，B栈中元素要和A栈中的元素保持一致性
        if (A.pop().equals(B.peek())) {
            B.pop();//B中元素出栈
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();//B中的栈顶元素就是其最小值
    }
}
