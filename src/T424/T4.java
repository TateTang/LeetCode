package T424;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2020/4/24 13:33
 * @Description 给定一个二叉树，找出其最大深度。
 *
 *              二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 *              说明: 叶子节点是指没有子节点的节点。
 *
 *              示例： 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *              3 / \ 9 20 / \ 15 7 返回它的最大深度 3 。
 */
public class T4 {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(3);
		TreeNode leftNode = new TreeNode(9);
		TreeNode rightNode = new TreeNode(20);
		treeNode.left = leftNode;
		treeNode.right = rightNode;
		rightNode.left = new TreeNode(15);
		rightNode.right = new TreeNode(7);
		// TreeNode.inOrderTraverse(treeNode);
		System.out.println(maxDepth(treeNode));
	}

	private static int maxDepth(TreeNode root) {
		// 那么我们数的当前树的最大深度就是其本身（1）+max（左子树的最大深度。右子树的最大深度）；
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);// 左子树深度
		int right = maxDepth(root.right);// 右子树深度
		return 1 + Math.max(left, right);// 返回最大的深度以及加上跟节点

	}
}
