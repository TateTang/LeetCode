package offer;

import com.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/8/7 8:50 下午
 * @Description 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Offer06 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(2);
        head.next = head1;
        head1.next = head2;
        System.out.println(Arrays.toString(new Offer06().reversePrint(head)));
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        //利用栈先进后出的特性进行迭代
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
