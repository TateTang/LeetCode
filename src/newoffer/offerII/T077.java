package newoffer.offerII;

import com.ListNode;

/**
 * @author tangmf
 * @date 2022年09月21日 12:54:​48
 * 剑指 Offer II 077. 链表排序
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 */
public class T077 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        ListNode.sout(head);
        ListNode.sout(new T077().sortList(head));
    }

    public ListNode sortList(ListNode head) {
        /*
        归并排序使用分治的思想。对链表归并排序，首先将链表拆分成多个不相交的子链表，对每个子链表排序，然后将排序后的子链表合并，合并过程中确保合并后的子链表仍然有序。合并结束之后，整个链表排序结束。
        使用自顶向下的方式实现时，首先判断链表的长度是否需要拆分。如果链表的长度是 00（即链表为空）或 11，则不需要拆分，此时链表已经有序，因此直接返回链表。
        当链表的长度大于 1 时，需要将链表拆分成两个子链表，对两个子链表分别排序，然后将排序后的两个子链表合并。具体做法如下。
        1.找到链表的中间结点。
        2.将中间结点的后一个结点作为第二个子链表的头结点，将中间结点和后一个结点之间的连接断开，
        此时链表拆分成两个子链表且两个子链表的长度之差不超过 1。
        3.对两个子链表调用递归完成排序。
        4.将排序后的两个子链表合并。
         */
        if (head == null || head.next == null) {
            return head;
        }
        //定义两个节点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(head2);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
         * 递归写法，
         * 1、如果有一个链表为空，返回另一个链表
         * 2、如果l1节点值比l2小，下一个节点应该是l1，应该return l1，
         * 在return之前，指定l1的下一个节点应该是l1.next和l2俩链表的合并后的头结点
         * 3、如果l1节点值比l2大，下一个节点应该是l2，应该return l2，
         * 在return之前，指定l2的下一个节点应该是l1和l2.next两链表的合并后的头结点
         */
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        //ListNode dummyHead = new ListNode(0);
        //ListNode temp = dummyHead;
        //while (l1 != null && l2 != null) {
        //    if (l1.val <= l2.val) {
        //        temp.next = l1;
        //        l1 = l1.next;
        //    } else {
        //        temp.next = l2;
        //        l2 = l2.next;
        //    }
        //    temp = temp.next;
        //}
        //if (l1 != null) {
        //    temp.next = l1;
        //} else {
        //    temp.next = l2;
        //}
        //return dummyHead.next;
    }
}
