package One_question_per_day;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2021/3/18 2:36 下午
 * @Description 92. 反转链表 II
 * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class T0318 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode firstNode = new ListNode(2);
        ListNode secondNode = new ListNode(3);
        ListNode threeNode = new ListNode(4);
        ListNode fourNode = new ListNode(5);
        head.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = threeNode;
        threeNode.next = fourNode;
        // ListNode.sout(head);
        int left = 2;
        int right = 4;
        ListNode.sout(reverseBetween(head, left, right));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        return null;
    }
}
