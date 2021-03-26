package daily;

import com.ListNode;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/3/25 11:12 上午
 * @Description 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Test83 {
    public static void main(String[] args) {
        // 创建一个头结点
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode.sout(head);

        ListNode.sout(deleteDuplicates1(head));
        ListNode.sout(deleteDuplicates2(head));


    }

    /**
     * 自己写的使用辅助栈
     *
     * @param head 链表
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        //使用栈操作，可以保证元素只有一个
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            if (!stack.isEmpty()) {
                if (stack.peek() == head.val) {
                    //栈顶元素等于下一个值，直接弹出
                    stack.pop();
                }
            }
            stack.push(head.val);
            head = head.next;
        }
        ListNode preNode = null;//前节点指针
        //每次循环，都将当前节点指向它前面的节点，然后前节点和当前节点都后移，直接反转即可，栈是先进后出
        while (!stack.isEmpty()) {
            ListNode currNode = new ListNode(stack.pop());//当前指针节点
            currNode.next = preNode;//将当前节点指向它前面的节点
            preNode = currNode;//前指针后移
        }
        return preNode;
    }


    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode currNode = head;//指定 cur 指针指向头部 head
        while (currNode != null && currNode.next != null) {
            //有相同的，删除，没有，下一位
            if (currNode.val == currNode.next.val) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }
        return head;
    }

    /**
     * 1.建一个虚拟头节点」 dummy以减少边界判断,往后的答案链表会接在dummy后面
     * 2.使用tail代表当前有效链表的结尾
     * 3.通过原输入的head指针进行链表扫描
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-109);
        ListNode tail = dummy;
        while (head != null) {
            // 值不相等才追加，确保了相同的节点只有第一个会被添加
            if (tail.val != head.val) {
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
