package newoffer.offerII;

import com.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author tangmf
 * @date 2022年10月18日 09:54:​10
 * 剑指 Offer II 025. 链表中的两数相加
 * 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
 * 将这两数相加会返回一个新的链表。
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例1：
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 */
public class T025 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        ListNode.sout(l1);

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;
        ListNode.sout(l2);
        ListNode.sout(new T025().addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //官方推荐使用deque代替stack，ArrayDeque 可变数组，双端队列
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;//进位为0
        ListNode resNode = null;//定义头节点
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int curr = a + b + carry;
            //栈顶元素>=10 需要进位，当前值为curr%10
            carry = curr / 10;
            curr %= 10;
            //使用头插法构建链表：将新形成的节点的下一个赋值为header，再把新形成的节点地址传给header，header向前移动
            //特点：1.新节点链接到链表头部，2.header永远存储第一个节点的地址
            ListNode currNode = new ListNode(curr);
            currNode.next = resNode;
            resNode = currNode;
        }
        return resNode;
    }
}
