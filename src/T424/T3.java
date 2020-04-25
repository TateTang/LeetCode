package T424;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2020/4/24 11:24
 * @Description 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。
 *              如果节点不存在，则返回 NULL。
 *
 *              例如，
 *
 *              给定二叉搜索树:
 *
 *              4 / \ 2 7 / \ 1 3
 *
 *              和值: 2 你应该返回如下子树:
 *
 *              2 / \ 1 3 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 */
public class T3 {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(4);
		TreeNode leftNode = new TreeNode(2);
		TreeNode rightNode = new TreeNode(7);
		treeNode.left = leftNode;
		treeNode.right = rightNode;
		leftNode.left = new TreeNode(1);
		leftNode.right = new TreeNode(3);
		TreeNode.inOrderTraverse(searchBST(treeNode, 2));
	}

	private static TreeNode searchBST(TreeNode root, int val) {

		/*
		 * 递归：
		 *
		 * 如果根节点为空 root == null 或者根节点的值等于搜索值 val == root.val，返回根节点。 如果 val <
		 * root.val，进入根节点的左子树查找 searchBST(root.left, val)。 如果 val >
		 * root.val，进入根节点的右子树查找 searchBST(root.right, val)。 返回根节点。
		 */
		if (root == null || val == root.val) {
			return root;
		}
		if (val < root.val) {
			return searchBST(root.left, val);// 进入根节点的左子树查找
		} else {
			return searchBST(root.right, val);// 进入根节点的右子树查找
		}
		/*
		 * 迭代： 如果根节点不空 root != null 且根节点不是目的节点 val != root.val：
		 *
		 * 如果 val < root.val，进入根节点的左子树查找 root = root.left。
		 *
		 * 如果 val > root.val，进入根节点的右子树查找 root = root.right。
		 *
		 * 返回 root。
		 *
		 */
		// while (root != null && val != root.val)
		// root = val < root.val ? root.left : root.right;
		// return root;
	}
}
