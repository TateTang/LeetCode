package offer;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2021/8/12 6:10 下午
 * @Description 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Offer24 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = new ListNode(5);
        ListNode.sout(node);
        ListNode.sout(new Offer24().reverseList2(node));
    }

    /**
     * 递归方法
     * 递归的两个两个条件：
     * 1、当前节点或者下一个节点是null值
     * 2、在函数内部，改变节点的指向，也就是head的下一个节点指向head递归函数那句
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        //这里的cur就是最后一个节点 就是5
        ListNode curr = reverseList(head.next);
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        head.next = null;//防止链表循环 next设置为空
        return curr;//每次递归返回最后一个节点接口 也就是 5 4 3 2 1
    }

    public ListNode reverseList2(ListNode head) {
        /*
        迭代：
          每次循环，都将当前节点指向它前面的节点，然后前节点和当前节点都后移
         */
        ListNode pre = null;//前节点指针
        ListNode cur = head;//当前节点指针
        while (cur != null) {
            ListNode nextTemp = cur.next;//临时节点，暂存当前节点的下一节点，用于后移
            cur.next = pre;//将当前节点指向它前面的节点
            pre = cur; //前指针后移
            cur = nextTemp;//当前指针后移
        }
        return pre;
    }
}
