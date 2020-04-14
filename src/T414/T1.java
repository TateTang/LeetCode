package T414;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2020/4/14 9:54
 * @Description 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *               
 *
 *              示例：
 *
 *              给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 *              返回链表 4->5.
 *
 */
public class T1 {

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
		int k = 2;
		ListNode listNode = getKthFromEnd(head, k);
		while (listNode != null) {
			if (listNode.next == null) {
				System.out.println(listNode.val);
			} else {
				System.out.print(listNode.val + " --> ");
			}
			listNode = listNode.next;
		}
	}

	private static ListNode getKthFromEnd(ListNode head, int k) {
		/*
		 * 快慢指针，倒数第k个节点与最后一个节点相差k-1个节点
		 * 1、初始化： 前指针 former 、后指针 latter ，双指针都指向头节点
		 * head​ 。
		 * 2、构建双指针距离： 前指针 former 先向前走 k 步（结束后，双指针 former 和 latter 间相距 k 步）。
		 * 3、双指针共同移动： 循环中，双指针 former 和 latter 每轮都向前走一步，直至 former 走过链表 尾节点
		 * 时跳出（跳出后， latter 与尾节点距离为 k-1，即 latter 指向倒数第 k 个节点）。
		 * 4、返回值： 返回 latter
		 */
		ListNode fast = head; //初始化
		ListNode slow = head;
		while (k-- > 1)
			fast = fast.next;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;

	}
}
