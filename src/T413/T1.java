package T413;

import com.TreeNode;
import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2020/4/13 17:17
 * @Description
 *
 * 				给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 *              示例: 给定有序数组: [-10,-3,0,5,9],
 *
 *              一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *              0 / \ -3 9 / / -10 5
 *
 */
public class T1 {

	public static void main(String[] args) {
		int[] nums = { -10, -3, 0, 5, 9 };
		System.out.println(sortedArrayToBST(nums).toString());

	}

	/**
	 *
	 *
	 * @param nums
	 */
	private static TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		// 将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组,注意这里包括下标from，不包括上标to。
		TreeNode root = new TreeNode(nums[(nums.length / 2)]);// 获取到中间的根节点
		root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, (nums.length / 2)));// 左子树
		root.right = sortedArrayToBST(Arrays.copyOfRange(nums, (nums.length / 2) + 1, nums.length));// 右子树
		return root;
	}

	// /**
	// * 由于是有序数组，就取数组中间点为根节点，左边为左子树，右边为右子树，依次递归。
	// */
	// private static TreeNode buildTree(int[] nums, int left, int right) {
	// if (left > right) {
	// return null;
	// }
	// int mid = (left + right) / 2;// 取出根节点
	// TreeNode root = new TreeNode(nums[mid]);
	// root.left = buildTree(nums, left, mid - 1);// 递归左子树
	// root.right = buildTree(nums, mid + 1, right);// 递归右子树
	// return root;
	// }
}
