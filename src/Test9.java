import com.ListNode;

/**
 * @Author tangmf
 * @Date 2020/4/9 16:52
 * @Description 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 *              请你返回该链表所表示数字的 十进制值 。 示例 1： 输入：head = [1,0,1] 输出：5 解释：二进制数 (101)
 *              转化为十进制数 (5)
 *
 */
public class Test9 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode firstNode = new ListNode(0);
		ListNode secondNode = new ListNode(1);
		head.next = firstNode;
		firstNode.next = secondNode;
		System.out.println(getDecimalValue(head));
	}

	// 链表移动到右侧下一个节点的过程，其实就是二进制数左移1位的结果
	private static int getDecimalValue(ListNode head) {
		int result = 0;
		ListNode cur = head;
		while (cur != null) {//101进入
			result = result << 1;// 左移一位，相当于乘以2
			result += cur.val; //将每一个的数据相加
			cur = cur.next;//获取下一个节点的值
		}
        /*
          101
          第一次 result = result << 1 = 0<<1=0  当前cur.val=1 result += cur.val = 1  cur = cur.next =0
          第二次 result = result << 1 = 1<<1=2  当前cur.val=0 result += cur.val = 2  cur = cur.next =1
          第三次 result = result << 1 = 2<<1=4  当前cur.val=1 result += cur.val = 5  cur ==null
         */
		return result;
	}

}
