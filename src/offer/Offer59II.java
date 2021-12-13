package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author tangmf
 * @Date 2021/12/8 4:16 下午
 * @Description 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 */
public class Offer59II {
    public static void main(String[] args) {
        Offer59II obj1 = new Offer59II();
        obj1.push_back(5);
        obj1.push_back(1);
        System.out.println(obj1.max_value());
        obj1.push_back(3);
        System.out.println(obj1.pop_front());
        System.out.println(obj1.max_value());
        System.out.println(obj1.pop_front());
    }

    /*
     * 解题思路：需要借助辅助队列
     * push_back 和 push_front 使用队列的操作即可完成，对于max_value函数，通常这样思考
     *  - 每次入队更新最大值
     *  - 出队时，会造成信息的缺失，无法确定下一个最大值，就是次大值，因此不可行
     *
     * 考虑使用一个递减列表来保存队列所有递减元素，递减链表随着入队和出队操作实时更新，这样队列最大元素始终对于递减列表的首元素
     *  queue 5 1 3 2
     *  deque(递减列表) 5 3 2  递减列表首元素 5 为最大值
     *  --->执行出队 pop_front()的时候，递减列表也需要出兑，保持两队列元素一直
     *  queue 1 3 2
     *  deque(递减列表)3 2 递减列表首元素 3 为最大值
     * 按照上面的逻辑，始终可以通过时间复杂度 O(1) 获取最大值
     * 为了实现此递减列表，需要使用双端队列，假设队列已经有若干元素：
     * 1、执行入队 push_back()时：若入队一个比队列某些元素更大的数字x，则为了保持此列表递减，需要将双端队列
     * 尾部所有小于x的元素弹出
     * 2、执行出队 pop_front()时：若出队的元素就是最大元素，则双端队列 需要同时将首元素出队，保持队列
     * 和双端队列的元素一致性
     *[使用双端队列的原因]：维护递减列表需要元素队首弹出，队尾插入，队尾弹出操作皆为O(1)时间复杂度
     *
     * 函数设计：
     * 初始化队列 queue，双端队列deque
     * 最大值 max_value()：
     * - 当双端队列deque为空，返回-1；
     * - 否则，返回deque 首元素
     * 入队 push_back()：
     * - 将元素value 入队queue；
     * - 将双端队列中队尾所有小于value的元素弹出（保持deque非单调递减），将元素value 入队deque
     * 出队 pop_front()：
     * - 若队列queue为空，返回-1
     * - 否则，将queue首元素出队
     * - 若deque 首元素和queue首元素相等，则将deque首元素出队（保持两队列值一致）
     *【 设计双端队列为单调不增的原因】：若队列queue中存在两个相同的最大值，此时queue和deque同时弹出一个
     * 最大元素，而queue中还有一个此最大元素，即采用单调递减将导致两队列中的元素不一致
     *
     * 复杂度分析
     * 时间复杂度O(1)： max_value(), push_back(), pop_front() 方法的均摊时间复杂度均为O(1)
     * 空间复杂度O(N) ： 当元素个数为 N 时，最差情况下deque 中保存N 个元素，使用O(N) 的额外空间；
     */
    Queue<Integer> queue;//队列定义
    Deque<Integer> deque;//双端队列定义

    public Offer59II() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();//最大值 双端队列首元素
    }

    public void push_back(int value) {
        queue.offer(value);//value入队queue

        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();//双端队列中队尾所有小于value的元素弹出
        }
        deque.offerLast(value);//元素入队到最后面
    }

    public int pop_front() {
        //弹出第一个值
        if (queue.isEmpty()) return -1;
        if (queue.peek().equals(deque.peekFirst())) {
            deque.pollFirst();//deque首元素出队
        }
        return queue.poll();//若deque 首元素和queue首元素相等，则将deque首元素出队（保持两队列一直）
    }
}
