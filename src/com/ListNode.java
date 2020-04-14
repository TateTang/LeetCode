package com;

/**
 * @Author tangmf
 * @Date 2020/4/9 16:54
 * @Description
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public static void sout(ListNode listNode) {
		while (listNode != null) {
			if (listNode.next == null) {
				System.out.println(listNode.val);
			} else {
				System.out.print(listNode.val + " --> ");
			}
			listNode = listNode.next;
		}
	}
}
