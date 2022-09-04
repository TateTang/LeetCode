package newoffer.offerII;

import com.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmf
 * @date 2022年09月04日 10:09:​10
 * 剑指 Offer II 027. 回文链表
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 * 示例 1：
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * 示例 2：
 * 输入: head = [1,2]
 * 输出: false
 */
public class T027 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(2);
        ListNode head5 = new ListNode(1);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        ListNode.sout(head);
        System.out.println(new T027().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        /*放入元素到list 中，然后使用双指针进行回文操作判断
         * 时间复杂度：O(n)，空间复杂度：O(n)
         * */

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
