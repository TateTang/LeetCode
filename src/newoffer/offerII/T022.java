package newoffer.offerII;

import com.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tangmf
 * @date 2022年09月30日 15:18:​02
 * 剑指 Offer II 022. 链表中环的入口节点
 * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 */
public class T022 {
    public static void main(String[] args) {
        ListNode headA = new ListNode();
        ListNode headA1 = new ListNode(3);
        ListNode headA2 = new ListNode(2);
        ListNode headA3 = new ListNode(0);
        ListNode headA4 = new ListNode(4);
        headA.next = headA1;
        headA1.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;
        ListNode.sout(new T022().detectCycle(headA));
    }

    public ListNode detectCycle(ListNode head) {
        /*
        哈希表：
        1.一个非常直观的思路是：我们遍历链表中的每个节点，并将它记录下来；
        2.一旦遇到了此前遍历过的节点，就可以判定链表中存在环。借助哈希表可以很方便地实现
         */
        ListNode pos = head;
        Set<ListNode> set = new HashSet<>();
        while (pos != null) {
            if (set.contains(pos)) {
                return pos;
            } else {
                set.add(pos);
            }
            pos = pos.next;//遍历
        }
        return null;
    }
}
