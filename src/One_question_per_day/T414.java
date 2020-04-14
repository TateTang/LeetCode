package One_question_per_day;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2020/4/14 15:58
 * @Description 给你两个 非空
 *              链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *              你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *              进阶：
 *
 *              如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *              示例：
 *
 *              输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 8 -> 0 -> 7
 *
 */
public class T414 {

	public static void main(String[] args) {
		// 创建一个头结点
		ListNode listNode = new ListNode(7);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		listNode.next = l1;
		l1.next = l2;
		l2.next = l3;

		ListNode listNode2 = new ListNode(5);
		ListNode l12 = new ListNode(6);
		ListNode l22 = new ListNode(4);
		listNode2.next = l12;
		l12.next = l22;
		ListNode.sout(listNode);
		ListNode.sout(listNode2);
        ListNode.sout(addTwoNumbers(listNode,listNode2));
	}

//	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		int addOne = 0;// 考虑进位
//		if (l1 == null && l2 == null)
//			return null;
//		ListNode dummyNode = new ListNode(0);// 值任意，指向头结点
//		ListNode head = dummyNode;// 赋值head 可以一直往下进行 指向dummyNode
//		while (l1 != null || l2 != null || addOne != 0) {
//			int val1 = l1 == null ? 0 : l1.val; // 查看值为多少
//			int val2 = l2 == null ? 0 : l2.val;
//			int sum = val1 + val2 + addOne;// 做加法
//			head.next = new ListNode(sum % 10);// 取算出来的个位数 如果是11 就取1，这个是头结点
//			head = head.next;// head前进一位 后移就是遍历
//			addOne = sum / 10;// 进位取得是 整除的余数，就是进位
//			if (l1 != null)
//				l1 = l1.next; // 向后移
//			if (l2 != null)
//				l2 = l2.next;
//		}
//		return dummyNode.next;
//	}
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    /*
	    本题的主要难点在于链表中数位的顺序与我们做加法的顺序是相反的，
	    为了逆序处理所有数位，我们可以使用栈：把所有数字压入栈中，再依次取出相加。计算过程中需要注意进位的情况。
	     */
        //利用栈存储链表元素，通过栈的先进后出的特性计算两数相加
        //指向表头，头结点压栈，指针移向下一个节点，把一个链表压入栈中，然后把第二个同样压入栈中
        //栈顶元素相加，首先计算低位，相加时使用头插法将输入逆序操作
        return null;
    }
}
