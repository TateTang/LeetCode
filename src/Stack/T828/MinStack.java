package Stack.T828;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/8/28 10:02
 * @Description 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 提示：
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 */
public class MinStack {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     * 两种实现方式：
     * 一、辅助栈和数据栈同步
     * 特点：编码简单，不用考虑一些边界情况，一点不好，辅助栈中可能会存一些不必要的元素
     * 二、辅助栈和数据栈不同步
     * 1、由“辅助栈和数据栈同步”的思想，我们知道，当数据栈进来的数越来越大的时候，
     * 我们要在辅助栈顶放置和当前辅助栈顶一样的元素，这样做有点“浪费”。基于这一点，我们做一些“优化”，但是在编码上就要注意一些边界条件。
     * (1)、辅助栈为空的时候，必须加入新元素
     * (2)、新元素小于或者等于辅助栈顶元素的时候，入栈。等于需要考虑，出栈的时候，连续的相等的并且最小的要同步出栈
     * (3)、出栈的时候，辅助栈栈顶元素等于数据栈栈顶元素，才出栈
     * 总结；入栈，最小值入栈才同步，出栈时，最小值出栈才同步。
     * 我们使用第二种试试
     */

    Stack<Integer> dataStack;//数据栈：保存正常入栈的值，
    Stack<Integer> helpStack;//辅助栈：存取最小值，用栈顶保存当前所有元素的最小值

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack = new Stack<>();
        helpStack = new Stack<>();
    }

    //将元素 x 推入栈中。
    public void push(int x) {
        dataStack.push(x);//数据栈需要直接入栈
        //辅助栈入栈条件，辅助栈为空的时候，必须加入新元素，新元素小于或者等于辅助栈顶元素的时候，入栈
        if (helpStack.isEmpty() || x <= helpStack.peek()) {
            helpStack.push(x);
        }
    }

    // 删除栈顶的元素。
    public void pop() {
        //出栈的时候，辅助栈栈顶元素等于数据栈栈顶元素，才出栈
        if (!dataStack.isEmpty()) {
            int top = dataStack.pop();//取出数据栈中的栈顶元素
            if (top == helpStack.peek()) {
                //相等辅助栈出栈
                helpStack.pop();
            }
        }
    }

    //获取栈顶元素。
    public int top() {
        if (!dataStack.isEmpty()) {
            return dataStack.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    // 检索栈中的最小元素。
    public int getMin() {
        if (!helpStack.isEmpty()) {
            return helpStack.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
