package T507;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2020/5/6 9:47
 * @Description 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s
 *              的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 *              示例 1: 给定的树 s:
 *
 *              3 / \ 4 5 / \ 1 2
 *
 *              给定的树 t：
 *
 *              4 / \ 1 2 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 */
public class Subtree {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(3);
		TreeNode leftNode = new TreeNode(4);
		TreeNode rightNode = new TreeNode(5);
		treeNode.left = leftNode;
		treeNode.right = rightNode;
		leftNode.left = new TreeNode(1);
		leftNode.right = new TreeNode(2);

		TreeNode treeNode1 = new TreeNode(4);
		TreeNode leftNode1 = new TreeNode(1);
		TreeNode rightNode1 = new TreeNode(2);
		treeNode1.left = leftNode1;
		treeNode1.right = rightNode1;
		TreeNode.inOrderTraverse(treeNode);
		TreeNode.inOrderTraverse(treeNode1);
		System.out.println(isSubtree(treeNode, treeNode1));
	}

	public static boolean isSubtree(TreeNode s, TreeNode t) {
		if (t == null)
			return true;
		if (s == null)
			return false;
		// t 为s的左子树或者t为s的右子树 还有就是 s和t是同一棵树
		return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
	}

	/**
	 * 判断两棵树是否相同的递归函数
	 */
	public static boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		if (s == null || t == null)
			return false;
		if (s.val != t.val)
			return false;
		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}
}
