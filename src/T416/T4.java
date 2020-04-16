package T416;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2020/4/16 14:26
 * @Description 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *               
 *
 *              示例:
 *
 *              输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */
public class T4 {

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
		ListNode.sout(reverseList(head));
	}

	private static ListNode reverseList(ListNode head) {
		/*
		 * 我们可以申请两个指针，第一个指针叫 pre，最初是指向 null 的。 第二个指针 cur 指向 head，然后不断遍历 cur。
		 * 每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。 都迭代完了(cur 变成 null
		 * 了)，pre 就是最后一个节点了。
		 *
		 */
		// 申请节点，pre和 cur，pre指向null
		ListNode pre = null;
		ListNode cur = head;
		ListNode temp;
		while (cur != null) {
			// 记录当前节点的下一个节点
			temp = cur.next;
			// 将当前节点指向pre
			cur.next = pre;
			// pre cur 前进一位
			pre = cur;
			cur = temp;
		}
		return pre;
	}
}
