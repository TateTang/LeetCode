package newoffer.offerII;

import com.ListNode;

import java.util.Stack;

/**
 * @author tangmf
 * @date 2022年09月29日 14:38:​11
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class T021 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode firstNode = new ListNode(2);
        ListNode secondNode = new ListNode(3);
        ListNode fourNode = new ListNode(4);
        ListNode fiveNode = new ListNode(5);
        head.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = fourNode;
        fourNode.next = fiveNode;
        int n = 2;
        ListNode.sout(new T021().removeNthFromEnd1(head, n));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        在对链表进行操作时，一种常用的技巧是添加一个哑节点（dummy node），
        它的 next 指针指向链表的头节点。这样一来，我们就不需要对头节点进行特殊的判断了
        如果我们要删除节点 y，我们需要知道节点 y 的前驱节点 x，并将 x 的指针指向 y 的后继节点。
        但由于头节点不存在前驱节点，因此我们需要在删除头节点时进行特殊判断。
        但如果我们添加了哑节点，那么头节点的前驱节点就是哑节点本身，此时我们就只需要考虑通用的情况即可

        快慢指针，倒数第 n 个节点与最后一个节点相差 n-1个节点
        1、初始化，快指针 fast，慢指针slow，都指向头节点
        2、构建距离：fast 向前走n 步（与slow 距离为n）
        3、双指针同时移动：fast、slow 每轮向前一步，fast 走过尾节点跳出，slow
        */
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);//定义一个哑节点，指向链表的头节点
        ListNode curr = dummy;//当前节点
        while (n-- > 1) {
            curr = curr.next;
        }
        return null;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        /*
        一种常用的技巧是添加一个哑节点（dummy node），它的 next 指针指向链表的头节点。
        这样一来，我们就不需要对头节点进行特殊的判断了
        利用栈来操作，先进后出，弹出栈的第n个节点就是需要删除的节点，
        并且目前栈顶节点就是待删除节点的前驱节点
         */
        ListNode dummy = new ListNode(0, head);
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        //待删除的前驱节点
        ListNode prev = stack.peek();
        //利用特性，将前驱节点指向它的后驱节点即可
        prev.next = prev.next.next;
        return dummy.next;
    }
}
