package T413;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2020/4/13 17:44
 * @Description 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 *              例如：
 *
 *              给定二叉树 [3,9,20,null,null,15,7]， 3 / \ 9 20 / \ 15 7返回它的最大深度 3 。
 *
 */
public class T2 {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(3);
		TreeNode leftNode = new TreeNode(9);
		TreeNode rightNode = new TreeNode(20);
		treeNode.left = leftNode;
		treeNode.right = rightNode;
		rightNode.left = new TreeNode(15);
		rightNode.right = new TreeNode(7);

//		inOrderTraverse(treeNode);
		System.out.println(maxDepth(treeNode));
	}

	private static int maxDepth(TreeNode root) {
		// 这个可以使用递归，分别求出左子树的深度、右子树的深度，两个深度的较大值+1即可。
		if (root == null) {
			return 0;
		} else {
			int left = maxDepth(root.left);// 左子树深度
			int right = maxDepth(root.right);// 右子树深度
			return left < right ? right + 1 : left + 1;
		}

	}

	private static void inOrderTraverse(TreeNode node) {
		if (node == null)
			return;
		inOrderTraverse(node.left);
		System.out.print(node.val);
		inOrderTraverse(node.right);
	}
}
