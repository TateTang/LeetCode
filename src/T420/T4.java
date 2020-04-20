package T420;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2020/4/20 14:58
 * @Description 翻转一棵二叉树。
 *
 *              示例：
 *
 *              输入：
 *
 *              4 / \ 2 7 / \ / \ 1 3 6 9 输出：
 *
 *              4 / \ 7 2 / \ / \ 9 6 3 1
 */
public class T4 {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(4);
		TreeNode leftNode = new TreeNode(2);
		TreeNode rightNode = new TreeNode(7);
		treeNode.left = leftNode;
		treeNode.right = rightNode;
		leftNode.left = new TreeNode(1);
		leftNode.right = new TreeNode(3);
		rightNode.left = new TreeNode(6);
		rightNode.right = new TreeNode(9);
		TreeNode.inOrderTraverse(treeNode);
		// System.out.println(invertTree(treeNode));
		TreeNode.inOrderTraverse(invertTree(treeNode));
	}

	private static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode temp = root.left;// 暂存root的左结点
		root.left = invertTree(root.right);// 左子树遍历
		root.right = invertTree(temp);// 右子树遍历
		return root;
	}
}
