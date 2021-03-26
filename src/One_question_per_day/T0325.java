package One_question_per_day;

import com.ListNode;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/3/25 9:07 下午
 * @Description 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
 * 请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 * 返回同样按升序排列的结果链表。
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 */
public class T0325 {
    public static void main(String[] args) {
        // 创建一个头结点
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode.sout(head);
        ListNode.sout(deleteDuplicates(head));
    }

    /*
        一次遍历解法：一边遍历、一边统计相邻节点的值是否相等，如果值相等就继续后移找到值不等的位置，然后删除值相等的区间
        思路：
        1、如果cur.val = cur.next.val，说明两个相邻的节点值相等，
        所以继续后移，一直找到cur.val!=cur.next.val，此时cur.next就是值不等的节点
        2、1->2->2->2->3;使用一个pre指向1，当cur指向第一个2的时候，发现cur.val = cur.next.val,
        节点值重复，所以cur一直后移到最后一个2的时候，发现cur.val!=cur.next.val。此时的cur.next =3。
        所以直接使用pre.next = cur.next即可，让1的next节点为3,把中间的2删除
        3、哑节点，dummy节点。迭代中非常常见。可能会删除头节点head。为了维护不变的头节点，添加了哑节点
        ，让dummy.next =head，这样即使head被删除了，那么会操作dummy.next指向新的链表头部。最终返回dummy.next

     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);//定义一个哑节点，指向链表的头节点
        ListNode curr = dummy;//当前节点
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                //对应元素相同，将 cur.next以及所有后面拥有相同元素值的链表节点全部删除
                int x = curr.next.val;//cur.next是变动的，val会变化。记下当前重复的值，后面不断删除。
                // 直到curr.next为空或者curr.next.val不等于x跳出，否则就是直接跳过当前
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                //对应元素不相同，只有一个元素值为cur.next的节点。直接遍历即可
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        //使用栈操作，可以保证元素只有一个
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            if (!stack.isEmpty()) {
                if (stack.peek() == head.val) {
                    //栈顶元素等于下一个值，直接弹出，原来的也要弹出
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

    /**
     * 1.建一个虚拟头节点」 dummy以减少边界判断,往后的答案链表会接在dummy后面
     * 2.使用tail代表当前有效链表的结尾
     * 3.通过原输入的head指针进行链表扫描
     * <p>
     * 我们会确保「进入外层循环时head不会与上ー节点相同」,因此为插入时机
     * 1.head已经没有下ー个节点,head可以被插入
     * 2.head有一下个节点,但是值与head不相同,head可以被插入
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (head != null) {
            // 进入循环时，确保了 head 不会与上一节点相同
            if (head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = tail.next;
            }
            // 如果 head 与下一节点相同，跳过相同节点
            while (head.next != null && head.val == head.next.val) head = head.next;
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
