package newoffer.offerII;

import com.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmf
 * @date 2022年10月19日 09:22:​38
 * 剑指 Offer II 026. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class T026 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(4);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        ListNode.sout(l1);
        new T026().reorderList(l1);
        ListNode.sout(l1);
    }

    public void reorderList(ListNode head) {
        /*利用线性表，链表支持下表访问，所以无法随机访问链表中任意位置的元素
        利用线性表可以下标访问的特点，直接安顺序访问指定元素，进行链表重建
         */
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
