package One_question_per_day;

import com.ListNode;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/3/27 10:13 上午
 * @Description 61. 旋转链表 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class T0327 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode.sout(head);
        ListNode.sout(rotateRight1(head, 2));
    }

    /**
     * 栈存储解法
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //对链表长度，求余，得到需要进行的调换的次数
        int nodeLengthen = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;//curr节点指向head
        while (head != null) {
            nodeLengthen++;//求长度
            stack.push(head);
            head = head.next;
        }
        for (int i = 1; i <= k % nodeLengthen; i++) {
            ListNode temp = stack.pop();//弹出栈顶元素 如5
            temp.next = curr;// 5-->指向head
            stack.peek().next = null;//并且让第二栈顶元素指向空
            curr = temp;//curr = temp 也就是5->1->2->3->4
        }
        return curr;
    }


    /**
     * 双指针解法
     */
    public static ListNode rotateRight1(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        /*
            快慢指针，倒数第k个节点与最后一个节点相差k-1个节点
            1、初始化，前指针，fase,后指针slow，指向head
            2、构建双指针距离，前指针向前走k步，结束后，双指针距离k步
            3、双指针共同移动，前指针和后指针都向前走一步，直到fase跳出时，
            此时latter与尾节点距离k-1，即latter指向倒数第k个节点。也就是链表旋转后的头节点
            4、快指针fast所指的尾节点的后继指针指向链表头节点，使链表成环。然后，
            倒数第K个节点作为链表旋转后的新的头节点，指针slow所指节点作为新的尾节点。
            5、慢指针所指向的后继节点指向null，断开节点
         */
        //计算需要遍历的次数，k对链表长度求余
        int count = k % calculateLen(head);
        ListNode fast = head;
        ListNode slow = head;
        ListNode curr = head;
        for (int i = 0; i < count; i++) {
            fast = fast.next;//快指针先向前移动k步
        }
        //快慢指针同时向前移动，直到快指针指向的节点的,下一个节点为null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = curr;// 快指针此时在链表末尾，然后其指向的节点的后继指针指向头节点，这时链表首尾相连成环
        curr = slow.next;// 新的头节点是慢指针所指节点的下一个节点
        slow.next = null;//慢指针所指向的后继节点指向null，断开节点
        return curr;
    }

    private static int calculateLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
