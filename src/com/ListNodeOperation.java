package com;

/**
 * @Author tangmf
 * @Date 2020/4/11 16:16
 * @Description
 */
public class ListNodeOperation {

	// 将一个新节点添加到链表尾部
	public static void addNode(ListNode listNode, ListNode node) {
		// 如果链表是一个空链表，则将此节点赋给链表
		if (listNode == null)
			listNode = node;
		if (listNode != null) {
			while (listNode.next != null) {
				listNode = listNode.next;
			}
			listNode.next = node;
		}
	}

	// 将node2节点插入到node1后面
	public static void addNode(ListNode listNode, ListNode node1, ListNode node2) {
		ListNode currNode;
		while (listNode.next != null) {
			currNode = listNode.next;
			if (currNode.val == node1.val) {
				// 注意这里需要先将插入的节点的next指向链表插入位置后面
				// 再将插入位置的next指向插入节点
				node2.next = currNode.next;
				listNode.next.next = node2;
				break;
			}
			listNode = currNode;
		}
	}

	// 删除链表中的某个值(此链表头结点不存入值）
	public static void removeNode(ListNode listNode, ListNode node) {
		ListNode currNode;
		while (listNode.next != null) {
			currNode = listNode.next;
			if (currNode.val == node.val) {
				listNode.next = currNode.next;
			}
			listNode = currNode;
		}
	}

	// 从头部到尾部打印出链表的值(跳过链表的头结点)
	public static void showListNode(ListNode listNode) {
		listNode = listNode.next;
		while (listNode != null) {
			System.out.print(listNode.val + " --> ");
			listNode = listNode.next;
		}
	}

	// 获取链表的长度
	public static int getLenOfLNode(ListNode listNode) {
		int len = 0;
		listNode = listNode.next;
		while (listNode != null) {
			len++;
			listNode = listNode.next;
		}
		return len;
	}

	public static void main(String[] args) {
		// 创建一个头结点
		ListNode listNode = new ListNode(0);
		// 创建三个节点，为后面测试使用
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(5);
		ListNode l3 = new ListNode(4);

		addNode(listNode, l1);
		addNode(listNode, l2);
		addNode(listNode, l3);
		showListNode(listNode);
		System.out.println("=====================");
		System.out.print("链表的长度为：");
		System.out.println(getLenOfLNode(listNode));
		System.out.println("=====================");
		System.out.println("删除l2节点：");
		 removeNode(listNode, l2);
		showListNode(listNode);
		System.out.println("=====================");
		System.out.println("插入l2节点");
		// addNode(listNode, l1, l2);
		// showListNode(listNode);
	}
}
