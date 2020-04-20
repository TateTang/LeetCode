package T417;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2020/4/17 9:31
 * @Description 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 *              你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL
 *              的节点将直接作为新二叉树的节点。
 *
 *              示例 1:
 *
 *              输入: Tree 1 Tree 2 1 2 / \ / \ 3 2 1 3 / \ \ 5 4 7 输出: 合并后的树: 3 /
 *              \ 4 5 / \ \ 5 4 7
 *
 */
public class T1 {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode leftNode = new TreeNode(3);
		TreeNode rightNode = new TreeNode(2);
		t1.left = leftNode;
		t1.right = rightNode;
		leftNode.left = new TreeNode(5);

		TreeNode t2 = new TreeNode(2);
		TreeNode leftNode2 = new TreeNode(1);
		TreeNode rightNode2 = new TreeNode(3);
		t2.left = leftNode2;
		t2.right = rightNode2;
		leftNode2.right = new TreeNode(4);
		rightNode2.right = new TreeNode(7);
		// TreeNode.inOrderTraverse(t1);
		// TreeNode.inOrderTraverse(t2);
		// System.out.println(mergeTrees(t1,t2));
		TreeNode.inOrderTraverse(mergeTrees(t1, t2));
	}

	private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		/*
		 * 递归算法：对这两棵树同时进行前序遍历，并将对应的节点进行合并。在遍历时，如果两棵树的当前节点均不为空，我们就将它们的值进行相加，
		 * 并对它们的左孩子和右孩子进行递归合并；如果其中有一棵树为空，那么我们返回另一颗树作为结果；
		 */
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;
		// 从根结点开始，合并规则相加不为 NULL 的节点将直接作为新二叉树的节点。
		t1.val = t1.val + t2.val;// 对应节点合并相加
		t1.left = mergeTrees(t1.left, t2.left);// 左子树合并
		t1.right = mergeTrees(t1.right, t2.right);// 右子树合并
		return t1;
	}

}
