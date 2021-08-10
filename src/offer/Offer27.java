package offer;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2021/8/9 8:13 下午
 * @Description 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class Offer27 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(7);
        node.left = leftNode;
        node.right = rightNode;
        leftNode.left = new TreeNode(1);
        leftNode.right = new TreeNode(3);
        rightNode.left = new TreeNode(6);
        rightNode.right = new TreeNode(9);
        TreeNode.preOrderTraverse(node);
        System.out.println();
        TreeNode.preOrderTraverse(new Offer27().mirrorTree(node));
    }

    public TreeNode mirrorTree(TreeNode root) {
        /*
        利用递归，原来的root left right 变成了 root right left
		 * 递归解析： 终止条件： 当节点 root 为空时（即越过叶节点），则返回 null ；
		 1、递推工作： 初始化节点 tmpt ，用于暂存root 的左子节点；
		 2、开启递归:  右子节点 mirrorTree(root.right) ，并将返回值作为 root 的 左子节点 。
         3、开启递归: 左子节点 mirrorTree(tmp) ，并将返回值作为 root 的 右子节点 。
         4、返回值： 返回当前节点 root ；
        */
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;//暂存
        root.left = mirrorTree(root.right);// 左子树遍历
        root.right = mirrorTree(temp);// 右子树遍历
        return root;
    }
}
