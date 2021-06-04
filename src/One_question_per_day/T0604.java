package One_question_per_day;

import com.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author tangmf
 * @Date 2021/6/4 9:56 上午
 * @Description 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 */
public class T0604 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode headA1 = new ListNode(1);
        ListNode headA2 = new ListNode(8);
        ListNode headA3 = new ListNode(4);
        ListNode headA4 = new ListNode(5);
        headA.next = headA1;
        headA1.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;
        ListNode.sout(headA);
        ListNode headB = new ListNode(5);
        ListNode headB1 = new ListNode(0);
        ListNode headB2 = new ListNode(1);
        ListNode headB3 = new ListNode(8);
        ListNode headB4 = new ListNode(4);
        ListNode headB5 = new ListNode(5);
        headB.next = headB1;
        headB1.next = headB2;
        headB2.next = headB3;
        headB3.next = headB4;
        headB4.next = headB5;
        ListNode.sout(headB);
        ListNode.sout(new T0604().getIntersectionNode(headA, headB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部,
         最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        /* 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头,
        而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null*/
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        /*
            哈希集合
            思路：判断两个链表是否相交，可以使用哈希集合存储链表节点
            1、首先遍历链表headA，将链表headA中的每个节点加入到哈希集合中，然后遍历链表headB，
            对于遍历到的每个，判断该节点是否在哈希集合中
            2、如果当前节点不在哈希集合中，继续遍历下一个节点
            3、如果当前节点在哈希集合中，则后面的节点都在哈希集合中，即从当前节点开始的所有节点都在
            两个链表的相交部分，因此在链表headB中遍历到的第一个在哈希集合中的节点就是两个链表相交的节点，返回节点
            4、headB的所有节点都不在哈希集合中，则两个链表不相交，返回null
            时间复杂度O(m+n)
            空间复杂度O(m)
         **/
        Set<ListNode> set = new HashSet<>();
        ListNode tempA = headA;
        while (tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while (tempB != null) {
            if (set.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }
}
