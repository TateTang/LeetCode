package T416;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2020/4/16 10:15
 * @Description 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 *              二叉搜索树保证具有唯一的值。
 *
 *               
 *
 *              示例 1：
 *
 *              输入：root = [10,5,15,3,7,null,18], L = 7, R = 15 输出：32
 */
public class T1 {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(10);
		TreeNode leftNode = new TreeNode(5);
		TreeNode rightNode = new TreeNode(15);
		treeNode.left = leftNode;
		treeNode.right = rightNode;
		leftNode.left = new TreeNode(3);
		leftNode.right = new TreeNode(7);
		rightNode.right = new TreeNode(18);
		// TreeNode.inOrderTraverse(treeNode);
		int L = 7;
		int R = 15;

		// System.out.println(mirrorTree(treeNode));
		// TreeNode.inOrderTraverse(mirrorTree(treeNode));
		System.out.println(rangeSumBST(treeNode, L, R));
	}

	private static int rangeSumBST(TreeNode root, int L, int R) {
		/*
		 * 深度优先搜索 我们对树进行深度优先搜索，对于当前节点 node，
		 * 1、如果 node.val 小于等于 L，那么只需要继续搜索它的右子树；
		 * 2、如果 node.val 大于等于 R，那么只需要继续搜索它的左子树；
		 * 3、如果 node.val 在区间 (L, R) 中，则需要搜索它的所有子树。
		 */
		// int sum = 0;
		if (root == null) {
			return 0;
		}
		if (root.val < L) {// 只搜索右子树
			return rangeSumBST(root.right, L, R);
		}
		if (root.val > R) {// 只搜索左子树树
			return rangeSumBST(root.left, L, R);
		}
		// 当L <= root.val && root.val <= R时，在区间内搜索所有子树
		return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
	}
}
