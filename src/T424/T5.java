package T424;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2020/4/24 13:43
 * @Description 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *               
 *
 *              示例 1:
 *
 *              输入: root = [3,1,4,null,2], k = 1 3 / \ 1 4 \   2 输出: 4
 */
/*
 * 递归算法(常用于树的问题)：
 *
 * 递归前：if判断递归是否要执行，一般都类似于if(condition){ 递归函数 }，剪枝作用
 * 递归中：判断递归如何要停下来，一般都类似于if(root==null){ return... }，触底反弹，进入下一个递归方法
 * 递归后：递归函数的结果如何处理： 1、直接return，如寻找最近公共祖先节点，具有排他性 2、收集递归结果处理，如找到二叉树深度，max(left,
 * right)+1
 */
public class T5 {

	private int res, k;

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(3);
		TreeNode leftNode = new TreeNode(1);
		TreeNode rightNode = new TreeNode(4);
		treeNode.left = leftNode;
		treeNode.right = rightNode;
		leftNode.right = new TreeNode(2);
		int m = 1;
		TreeNode.inOrderTraverse(treeNode);
		// System.out.println(maxDepth(treeNode));
		// System.out.println(kthLargest(treeNode, k));\
		System.out.println(new T5().kthLargest(treeNode, m));
	}

	private int kthLargest(TreeNode root, int k) {
		// 中序遍历顺序 左 根 右 递增序列
		// 中序遍历倒序 右 根 左 递减序列
		/*
		 * 终止条件： 当节点 root 为空（越过叶节点），则直接返回； 递归右子树： 即 dfs(root.right) ； 三项工作：
		 * 提前返回： 若 k = 0 ，代表已找到目标节点，无需继续遍历，因此直接返回； 统计序号： 执行 k = k - 1 （即从 k 减至 0
		 * ）； 记录结果： 若 k = 0 ，代表当前节点为第 k 大的节点，因此记录res=root.val ； 递归左子树： 即
		 * dfs(root.left)；
		 */
		this.k = k;
		dfs(root);
		return res;
	}

	private void dfs(TreeNode node) {
		if (node == null) {
			return;
		}
		dfs(node.right);
		if (k == 0)
			return;// 找到目标节点
		if (--k == 0)// 减减在前 先运算 后 减减
			res = node.val; // 代表当前节点为第k大的节点
		dfs(node.left);
	}
}
