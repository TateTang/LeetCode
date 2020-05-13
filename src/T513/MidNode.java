package T513;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2020/5/13 11:28
 * @Description 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 *              如果有两个中间结点，则返回第二个中间结点。
 *
 *               
 *
 *              示例 1：
 *
 *              输入：[1,2,3,4,5] 输出：此列表中的结点 3 (序列化形式：[3,4,5]) 返回的结点值为 3 。
 *              (测评系统对该结点序列化表述是 [3,4,5])。 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 *              ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及
 *              ans.next.next.next = NULL.
 */
public class MidNode {

	public static void main(String[] args) {
		// 创建一个头结点
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
		ListNode.sout(middleNode1(listNode));
	}

	public static ListNode middleNode(ListNode head) {
		/*
		 * 1、数组的方式 链表的缺点在于不能通过下标访问对应的元素。因此我们可以考虑对链表进行遍历，同时将遍历到的元素依次放入数组 A
		 * 中。如果我们遍历到了 N 个元素，那么链表以及数组的长度也为 N，对应的中间节点即为 A[N/2]。
		 */
		ListNode[] A = new ListNode[100];
		int t = 0;
		while (head != null) {
			A[t++] = head;
			head = head.next;
		}
		return A[t / 2];
	}

	public static ListNode middleNode1(ListNode head) {
		/*
		 * 我们可以继续优化方法二，用两个指针 slow 与 fast 一起遍历链表。slow 一次走一步，fast 一次走两步。那么当 fast
		 * 到达链表的末尾时，slow 必然位于中间。
		 */
		ListNode slow = head, fast = head;// 定义快慢两个指针
		while (fast != null && fast.next != null) {
			slow = slow.next;// slow一次走一步
			fast = fast.next.next;// fast一次走两步
		}
		return slow;
	}
}
