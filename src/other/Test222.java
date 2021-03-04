package other;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2021/3/4 8:00 下午
 * @Description 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~2h个节点。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 * 输入：root = []
 * 输出：0
 * <p>
 * 利用完全二叉树的特性，求高度只需看左子树 -> 二分法
 * <p>
 * 1、计算某节点的左子的左屋檐 ，右子的左屋檐
 * 2、左边 == 右边，说明左边是完全的，直接公式
 * 3、左边 > 右边，说明右边是完全的，直接公式
 *
 * 满二叉树总结点数：2^n -1
 */
public class Test222 {
    //时间复杂度：T(n) = T(n / 2) + logn 使用主定理的特殊情况，可以求得时间复杂度是O(logn * logn)
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left=new TreeNode(4);
        leftNode.right=new TreeNode(5);
        rightNode.left=new TreeNode(6);
        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);//计算左子树的高度
        int rightHeight = getHeight(root.right);//计算右子树的高度
        // 1<< 移位运算符 相当于
        //left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了 2^n -1 加上root节点就是 2^n
        if (leftHeight == rightHeight) {
            //2^left统计 加上 右子树的统计 2^right
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            //说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数 2^right
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    /**
     * 计算高度的函数
     *
     * @param root 节点
     */
    public static int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
}
