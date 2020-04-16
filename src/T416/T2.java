package T416;

import com.ListNode;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/4/16 11:21
 * @Description 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 *              示例 1：
 *
 *              输入：head = [1,3,2] 输出：[2,3,1]
 */
public class T2 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode firstNode = new ListNode(3);
		ListNode secondNode = new ListNode(2);
		head.next = firstNode;
		firstNode.next = secondNode;
		// ListNode.sout(head);
		System.out.println(Arrays.toString(reversePrint(head)));
	}

	/*
	 * 创建一个栈，用于存储链表的节点 创建一个指针，初始时指向链表的头节点 当指针指向的元素非空时，重复下列操作：
	 * 将指针指向的节点压入栈内
	 * 将指针移到当前节点的下一个节点 获得栈的大小 size，创建一个数组 print，其大小为 size 创建下标并初始化 index = 0 重复
	 * size 次下列操作： 从栈内弹出一个节点，将该节点的值存到 print[index] 将 index 的值加 1 返回 print
	 *
	 */
	private static int[] reversePrint(ListNode head) {
		Stack<Integer> stack = new Stack<>();// 定义一个栈 先进后出
        ListNode temp=head;
		while (temp != null) {
			stack.push(temp.val);//入栈
            temp = temp.next;// 遍历
		}
		int[] arr = new int[stack.size()];//初始化数组
		for (int i = 0; i < arr.length; i++) {
			arr[i] = stack.pop();//出栈
		}
		return arr;
	}
}
