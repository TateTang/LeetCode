package One_question_per_day;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2020/9/16 6:53 下午
 * @Description 226. 翻转二叉树
 * 难度
 * 简单
 * 610
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class T226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);
        TreeNode.preOrderTraverse(root);
        System.out.println("---------------");
        System.out.println(invertTree(root));
        TreeNode.preOrderTraverse(invertTree(root));

    }

    public static TreeNode invertTree(TreeNode root) {
        //递归实现
        if (root == null) {
            return null;
        }
        TreeNode leftTree = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = leftTree;
        return root;
    }
}
