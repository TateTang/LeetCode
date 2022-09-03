package newoffer.offerII;

import com.ListNode;

/**
 * @author tangmf
 * @date 2022年09月03日 10:23:​00
 * 剑指 Offer II 024. 反转链表
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */
public class T024 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        ListNode.sout(head);
        ListNode.sout(new T024().reverseList1(head));
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;//前节点指针
        ListNode cur = head;//当前节点指针
        // 每次循环，将当前节点指向它前面的节点，然后前节点和当前节点后移动
        while (cur != null) {
            // 临时节点，存储当前节点的下一个节点，用于后移动
            ListNode nextTemp = cur.next;
            cur.next = pre;//当前节点指向它前面节点
            //前指针后移，当前指针后移
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        /*
         * 递归方法
         * 递归的两个两个条件：
         * 1、当前节点或者下一个节点是null值
         * 2、在函数内部，改变节点的指向，也就是head的下一个节点指向head递归函数那句
         */
        //终止条件 当前节点或者下一个节点是null值
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点 就是5
        ListNode curr = reverseList1(head.next);
        //如果链表是 1->2->3->4->5，那么此时的cur就是5，而head是4，head的下一个是5，下下一个是空，所以head.next.next 就是5->4
        head.next.next = head;
        head.next = null;//防止链表循环 next设置为空
        return curr;//每次递归返回最后一个节点接口 也就是 5 4 3 2 1
    }
}
