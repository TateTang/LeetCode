package Stack.T829;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author tangmf
 * @Date 2020/8/29 11:06
 * @Description 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
public class MyStack {
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    //队列 先进先出 ，栈先进后出
    /*1、queue 有弹出队尾元素 方法 poll();
    2、执行push 操作的时候将所有的 元素都加入到queue1中去
    3、执行pop 操作的时候，将queue1中的n-1个元素，(n=queue1.size())poll() 到queue2中，
        此时poll() queue1中的元素实现pop操作，操作结束后再将queue2中的元素重新添加到queue1中
    4、执行top 操作的时候 和pop操作类似，记录最后一个元素，再将元素poll到queue2中，
        结束后 将queue2中的元素添加到queue1中
     */
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public static void main(String[] args) {

    }

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        //执行push 操作的时候将所有的 元素都加入到queue1中去
        queue1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        //将queue1中的n-1个元素，(n=queue1.size())poll() 到queue2中，
        // 此时poll() queue1中的元素实现pop操作，操作结束后再将queue2中的元素重新添加到queue1中
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int ans = queue1.poll();
        while (queue2.size() > 0) {
            queue1.add(queue2.poll());
        }
        return ans;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (queue1.size() > 1)
            queue2.add(queue1.poll());
        int ans = queue1.peek();
        queue2.add(queue1.poll());
        while (queue2.size() > 0)
            queue1.add(queue2.poll());
        return ans;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
