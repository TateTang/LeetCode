package offer;

import com.Node;

/**
 * @Author tangmf
 * @Date 2021/11/18 10:58 上午
 * @Description 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 *  
 * <p>
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
 * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，
 * 树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 */
public class Offer36 {
    Node pre, head;//定义两个节点 pre 和 head

    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(2);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        node.right = new Node(5);
        System.out.println(new Offer36().treeToDoublyList(node));
    }

    public Node treeToDoublyList(Node root) {
        /*
        二叉树的中序遍历为递增序列 左 根 右
        二叉搜索树特性：所有左子节点的值小于根节点，所有右子节点的值大于根节点
        将二叉搜索树转换成一个排序的循环双向链表，三要素
        - 1.排序链表：节点从小到大排序，因此使用 中序遍历 访问树的节点
        - 2.双向链表：构建相邻节点的引用关系时，设前驱节点pre和当前节点cur，不仅应构建pre.right = cur，
        而且应构建cur.left = pre
        - 3.循环链表：设置链表头节点head和尾节点tail，应该构建head.left = tail，tail.right = head,

        1 2 3 4 5
        双向：2.right =3 3.left = 2
        循环：1.left = 5，5.right=1

        考虑使用中序遍历访问树的各节点 cur ；并在访问每个节点时构建 cur 和前驱节点 pre 的引用指向；
        中序遍历完成后，最后构建头节点和尾节点的引用指向即可

        算法流程：
        dfs(cur)：递归法中序遍历
        1.终止条件：节点cur为空，代表越过叶节点，直接返回；
        2.递归左子树：dfs(cur.left)
        3.构建链表:
            - pre为空：代表正在访问链表头节点，计为head；
            - pre不为空：修改双向节点引用，pre.right = cur，cur.left = pre;
            - 保存cur：更新pre = cur，即节点cur是后继节点的pre。
        4.递归右子树：dfs(cur.right)

        treeToDoublyList(root):
        1.特例处理：节点root为空，返回
        2.初始化：空节点pre
        3.转换为双向链表：调用dfs(root);
        4.构建循环链表：中序遍历完成后，head 指向头节点，pre指向尾节点，修改head和pre的双向节点引用接口
        5.返回值：返回链表的头节点head即可
         */
        if (root == null) return null;
        dfs(root);//转换为双向链表
        head.left = pre; //进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的
        pre.right = head;
        return head;
    }

    void dfs(Node curr) {
        if (curr == null) return;
        dfs(curr.left);
        if (pre == null){
            //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,
            //当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
            head = curr;
        }else {
            //反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作。
            pre.right = curr;
        }
        //pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。双向的，左子节点就是前驱节点
        curr.left = pre;
        //pre指向当前的cur，指针后移一位，保存cur：更新pre = cur，即节点cur是后继节点的pre
        pre = curr;
        dfs(curr.right);
    }
}
