package offer;

import com.ListNode;

/**
 * @Author tangmf
 * @Date 2021/8/12 5:41 下午
 * @Description 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class Offer18 {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode.sout(node);
        int val = 5;
        ListNode.sout(new Offer18().deleteNode(node, val));
    }

    public ListNode deleteNode(ListNode head, int val) {
         /*
            删除所有相同的节点 node.val = val
            迭代：
            1、定义节点curr，表示是当前节点
            2、如果curr的下一个节点不为空且下一个节点的节点值等于val，
            需要删除下一个节点：就是curr.next = curr.next.next
            3、如果curr的下一个节点值不等于val，保留下一个节点，移动到下一个节点即可
            4、curr下一个节点为空，代表遍历结束，此时所有节点值等于val都被删除
            5、由于链表都节点head可能被删除，创建哑节点dummy，dummy指向head，初始化当前节点curr=dummy
            6、遍历删除，返回next为删除操作后的节点
         */
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);//定义一个哑节点，指向链表的头节点
        ListNode curr = dummy;//当前节点
        //curr.next才是真正的节点
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
