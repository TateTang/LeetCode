package T422;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2020/4/22 16:46
 * @Description 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 *              示例1：
 *
 *              输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4 限制：
 *
 *              0 <= 链表长度 <= 1000
 */
public class T5 {

	public static void main(String[] args) {
		// 创建一个头结点
		ListNode listNode = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		listNode.next = l1;
		l1.next = l2;

		ListNode listNode2 = new ListNode(1);
		ListNode l12 = new ListNode(3);
		ListNode l22 = new ListNode(4);
		listNode2.next = l12;
		l12.next = l22;
		ListNode.sout(listNode);
		ListNode.sout(listNode2);
		ListNode.sout(mergeTwoLists(listNode, listNode2));
	}

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		/*
		 * 解题思路： 根据题目描述,链表l1, l 2是递增的因此容易想到使用双指针 l1和 l2遍历两链表，根据 l1.vall,l2.val
		 * 的大小关系确定节点添加顺序，两节点指针交替前进，直至遍历完毕。 引入伪头节点：
		 * 由于初始状态合并链表中无节点，因此循环第一轮时无法将节点添加到合并链表中。 解决方案：初始化一个辅助节点 dummyNode
		 * 作为合并链表的伪头节点，将各节点添加至 dummyNode 之后。
		 *
		 * 算法流程： 1、初始化： 伪头节点 dummyNode ，节点 currNode 指向 dummyNode 。 2、循环合并： 当 l1或
		 * l2为空时跳出； 1、当 l1.val < l2.vall 时cur的后继节点指定为 l1，l1向前走一步； 2、当 l1.val >
		 * l2.vall 时cur的后继节点指定为 l2，l2向前走一步； 3、节点 cur向前走一步，即 currNode =
		 * currNode.next。 3、合并剩余尾部： 跳出时有两种情况，即 l1为空或 l2为空。 若 l1!=nulll,将l1添加至节点
		 * cur之后； 否则：将l2添加至节点 cur之后。 4、返回值： 合并链表在伪头节点 dumdum 之后，因此返回 dum.next
		 * 即可。
		 */
		ListNode a = l1; // 指向第一个链表
		ListNode b = l2;// 指向第二个链表
		ListNode dummyNode = new ListNode(0);// 初始化一个值为 0 的节点，变量 node 引用指向它
		ListNode currNode = dummyNode; // 节点 currNode 指向 dummyNode
		while (a != null && b != null) {
			if (a.val < b.val) {// 当 l1.val < l2.vall 时cur的后继节点指定为 l1，l1向前走一步
				currNode.next = a;
				a = a.next;
			} else {// 当 l1.val > l2.vall 时cur的后继节点指定为 l2，l2向前走一步；
				currNode.next = b;
				b = b.next;
			}
			currNode = currNode.next;// 节点 cur向前走一步，即 currNode = currNode.next
		}
		if (a != null) {
			currNode.next = a;// 当l1!=nulll,将l1添加至节点 cur之后
		} else {
			currNode.next = b;// 将l2添加至节点 cur之后
		}
		return dummyNode.next;
	}
}
