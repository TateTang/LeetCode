package Stack.T827;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/8/27 10:52
 * @Description 剑指 Offer 09. 用两个栈实现队列用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"] 这一行表示每一行代码的操作
 * [[],[3],[],[]] 这个表示每一行代码操作所需要的参数
 * 输出：[null,null,3,-1]
 *
 *
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * 分析：使用先进后出的栈去实现先进先出的列，
 * 题目要求queue弹出的元素，是stack1最下面的元素，也是stack2最上面的元素
 * 说明示例1
 * 1、CQueue,创建队列，返回值为null
 * 2、appendTail，将3压入栈中，返回值为null
 * 3、deleteHead，将栈底元素删除，也就是先进来的元素，所以是3
 * 4、deleteHead，继续删除，元素不存在，所以-1；
 */
public class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(3);
        int param1 = obj.deleteHead();
        int param2 = obj.deleteHead();
        System.out.println(param1 + " " + param2);
    }

    private CQueue() {
        //构造函数，进行初始化的操作的。
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //队列尾部插入整数的功能
    private void appendTail(int value) {
        stack1.push(value);//实现入栈功能 压入栈中
    }

    //队列头部删除整数的功能
    private int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;//若队列中没有元素，deleteHead 操作返回 -1
            }
            while (!stack1.isEmpty()) {
                //不为空，需要将stack1中的元素 也就是栈顶元素，压入到stack2的栈底去，这样就实现了先进后出的栈的元素，能够先进先出
                stack2.push(stack1.pop());
            }
            return stack2.pop();//出栈
        } else {
            //stack2不为空，说明需要出栈
            return stack2.pop();
        }
    }
}
