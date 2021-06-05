package One_question_per_day;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2021/6/5 10:32 上午
 * @Description 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class T0605 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headA1 = new ListNode(2);
        ListNode headA2 = new ListNode(6);
        ListNode headA3 = new ListNode(3);
        ListNode headA4 = new ListNode(4);
        ListNode headA5 = new ListNode(5);
        ListNode headA6 = new ListNode(6);
        headA.next = headA1;
        headA1.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;
        headA4.next = headA5;
        headA5.next = headA6;
        ListNode.sout(headA);
        int val = 6;
        ListNode.sout(new T0605().removeElements(headA, val));
    }

    public ListNode removeElements(ListNode head, int val) {
        /*
            删除所有相同的节点 node.val = val
            迭代：
            1、定义节点curr，表示是当前节点
            2、如果curr的下一个节点不为空且下一个节点的节点值等于val，
            需要删除下一个节点：就是curr.next = curr.next.next
            3、如果curr的下一个节点值不等于val，保留下一个节点，移动到下一个节点即可
            4、curr下一个节点为空，代表遍历结束，此时所有节点值等于val都被删除
            5、由于链表都节点head可能被删除，创建哑节点dummy，dummy指向head，初始化当前节点curr=dummy
            6、遍历删除，返回next为删除操作后的节点
         */
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);//定义一个哑节点，指向链表的头节点
        ListNode curr = dummy;//当前节点
        while (curr.next != null) {
            //有相同的，删除，没有，下一位
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
