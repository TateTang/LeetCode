package T414;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2020/4/14 10:36
 * @Description 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 *              例如输入：
 *
 *                   4    /   \   2     7  / \   / \ 1   3 6   9 镜像输出：
 *
 *                   4    /   \   7     2  / \   / \ 9   6 3   1 总结一下
 *              链表使用的是head.next 而在二叉树中多实用的是递归来进行左子树和右子树的赋值以及取出
 */
public class T2 {

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
		System.out.println(mirrorTree(treeNode));
		TreeNode.inOrderTraverse(mirrorTree(treeNode));
	}

	private static TreeNode mirrorTree(TreeNode root) {
		// 镜像 root left right 变成 root right left
		/*
		 * 递归解析： 终止条件： 当节点 root 为空时（即越过叶节点），则返回 null ； 递推工作： 初始化节点 tmptmp ，用于暂存
		 * root 的左子节点； 开启递归 右子节点 mirrorTree(root.right) ，并将返回值作为 root 的 左子节点 。
		 * 开启递归 左子节点 mirrorTree(tmp) ，并将返回值作为 root 的 右子节点 。 返回值： 返回当前节点 root ；
		 */
		if (root == null) {
			return null;
		}
		TreeNode tmp = root.left; // 暂存root的左子节点
		root.left = mirrorTree(root.right);// 左子树遍历
		root.right = mirrorTree(tmp);// 右子树遍历
		return root;
	}
}
