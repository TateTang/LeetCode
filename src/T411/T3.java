package T411;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2020/4/11 17:00
 * @Description
 */
public class T3 {

	public static void main(String[] args) {
		// 创建一个头结点
		ListNode listNode = new ListNode(1);
		// 创建三个节点，为后面测试使用
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(5);
		listNode.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		int k = 2;
		System.out.println(kthToLast(listNode, k));
	}

	// private static int kthToLast(ListNode head, int k) {
	// int index = 0;
	// List<Integer> list = new ArrayList<>();
	// while (head != null) {
	// if (head.next == null) {
	// // System.out.println(head.val);
	// list.add(head.val);
	// } else {
	// // System.out.print(head.val + " --> ");
	// list.add(head.val);
	// }
	// head = head.next;// 下一个节点
	// }
	// for (int i = list.size() - 1; i >= 0; i--) {
	// if (k == list.size() - i) {// k-1 = list-i-1 k =list.size()-i
	// // list-i获取到的是逆序输出的数字为第几个 如5 为第一个
	// index = list.get(i);// 取出的是第几个数字
	// }
	// }
	// return index;
	// }

	/**
	 * 充分利用条件“给定的 k 保证是有效的”。 递归，访问到最后的节点，再往前找之前的状态。 双指针，k既是倒数的节点，也是该节点与最末尾节点的距离。
	 */
	private static int kthToLast(ListNode head, int k) {
		ListNode p = head;
		for (int i = 0; i < k; i++) {
			p = p.next;
		}
		while (p != null) {
			p = p.next;
			head = head.next;
		}
		return head.val;
	}
}
