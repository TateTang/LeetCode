package com;

/**
 * @Author tangmf
 * @Date 2020/4/13 17:19
 * @Description
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	// 前序遍历输出
	public static void preOrderTraverse(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val + " ");
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}

	// 中序遍历输出
	public static void inOrderTraverse(TreeNode node) {
		if (node == null)
			return;
		inOrderTraverse(node.left);
		System.out.print(node.val + " ");
		inOrderTraverse(node.right);
	}

	// 后序遍历输出
	public static void postOrderTraverse(TreeNode node) {
		if (node == null)
			return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
		System.out.print(node.val + " ");
	}

}
