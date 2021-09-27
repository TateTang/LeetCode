package offer;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2021/8/20 2:13 下午
 * @Description 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class Offer55II {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        //TreeNode.inOrderTraverse(root);
        System.out.println(new Offer55II().isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        //左右子树的深度相差不超过1 判断左子节点和右子节点是否平衡
        if (root == null) {
            return true;
        } else {
            return Math.abs(depth(root.left) - depth(root.right)) <= 1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    //深度
    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
