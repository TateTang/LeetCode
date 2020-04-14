package T411;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2020/4/11 16:11
 * @Description
 */
public class T1 {

	public static void main(String[] args) {
		// 创建一个头结点
		ListNode listNode = new ListNode(0);
		// 创建三个节点，为后面测试使用
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		listNode.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l3;
		// while (listNode != null) {
		// if (listNode.next == null) {
		// System.out.println(listNode.val);
		// } else {
		// System.out.print(listNode.val + " --> ");
		// }
		// listNode = listNode.next;
		// }
		deleteNode(listNode);
	}

	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
