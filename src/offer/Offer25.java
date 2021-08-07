package offer;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2021/8/7 9:19 下午
 * @Description 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Offer25 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        l1.next = l11;
        l11.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        l2.next = l21;
        l21.next = new ListNode(4);
        ListNode.sout(new Offer25().mergeTwoLists1(l1, l2));
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
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        /*
         * 迭代写法，
         * 1、设置dummy为一个哑节点，放置于链表之前，最后返回的就是dummy.next，设置cur为当前结点，从dummy开始
         * 2、当两个链表都不为空的时候进入循环，令新链表的下一个结点cur.next为val更小的结点，相应的链表的后移一位
         * 3、每次循环cur 也需要后移一位
         * 4、如果循环结束后还有链表非空，cur指向空链表
         * 5、返回dummy就是结果
         */
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;//新链表的下一个结点为更小的值
                l1 = l1.next;//链表后移一位
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            //cur向后移一位
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
