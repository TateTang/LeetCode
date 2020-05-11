package T507;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2020/5/7 16:20
 * @Description 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 *              本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 *              示例:
 *
 *              给定有序数组: [-10,-3,0,5,9],
 *
 *              一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *              0 / \ -3 9 / / -10 5
 */
public class ArrayToBST {

    int[] nums;
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(4);
		TreeNode leftNode = new TreeNode(2);
		TreeNode rightNode = new TreeNode(5);
		treeNode.left = leftNode;
		treeNode.right = rightNode;
		leftNode.left = new TreeNode(1);
		leftNode.right = new TreeNode(3);

        System.out.println();
	}

	public  TreeNode sortedArrayToBST(int[] nums) {
	    this.nums=nums;
		return helper(0,nums.length-1);
	}
	public  TreeNode helper(int left, int right){
        /*
         * 中序遍历：始终选择中间位置左边的元素作为根节点
         * 步骤： 方法 helper(left, right) 使用数组 nums 中索引从 left 到 right 的元素创建 BST：
         * 1、如果 left > right，子树中不存在元素，返回空。
         * 2、找出中间元素：p = (left + right) /2。
         * 3、创建根节点：root = TreeNode(nums[p])。
         * 4、递归创建左子树 root.left = helper(left, p - 1) 和右子树 root.right = helper(p + 1, right)。
         * 5、返回 helper(0, len(nums) - 1)。
         */
        if (left > right) return null;
        int p = (left + right) / 2;//中间元素
        //中序遍历 left ->node ->right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left,p-1);//左子树
        root.right = helper(p+1, right);//右子树
        return root;
    }
}
