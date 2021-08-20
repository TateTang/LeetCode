package offer;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2021/8/20 2:08 下午
 * @Description 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class Offer55I {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        //TreeNode.inOrderTraverse(root);
        System.out.println(new Offer55I().maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        /*
        左子树的高度和右子树的高度 +1 1：根节点的高度
         */
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
