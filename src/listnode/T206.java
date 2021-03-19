package listnode;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2021/3/18 10:09 上午
 * @Description 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class T206 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        listNode.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode.sout(listNode);
        //ListNode.sout(reverseList(listNode));
        ListNode.sout(reverseList2(listNode));
    }

    /**
     * 迭代方法
     *
     * @param head listnode
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;//前节点指针
        ListNode cur = head;//当前节点指针
        //每次循环，都将当前节点指向它前面的节点，然后前节点和当前节点都后移
        while (cur != null) {
            ListNode nextTemp = cur.next;//临时节点，暂存当前节点的下一节点，用于后移
            cur.next = pre;//将当前节点指向它前面的节点
            pre = cur; //前指针后移
            cur = nextTemp;//当前指针后移
        }
        return pre;
    }

    /**
     * 递归方法
     * 递归的两个两个条件：
     * 1、当前节点或者下一个节点是null值
     * 2、在函数内部，改变节点的指向，也就是head的下一个节点指向head递归函数那句
     */
    public static ListNode reverseList2(ListNode head) {
        //终止条件 当前节点或者下一个节点是null值
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点 就是5
        ListNode curr = reverseList2(head.next);
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next=head;
        head.next=null;//防止链表循环 next设置为空
        return curr;//每次递归返回最后一个节点接口 也就是 5 4 3 2 1
    }

}
