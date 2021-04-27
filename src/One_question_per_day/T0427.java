package One_question_per_day;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2021/4/27 11:36 上午
 * @Description 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * 二叉搜索树（二叉排序树）：
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 它的左、右子树也分别为二叉排序树。
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 */
public class T0427 {
    int low = 7;
    int high = 10;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode leftNode = new TreeNode(5);
        TreeNode rightNode = new TreeNode(15);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        leftNode.left = new TreeNode(3);
        leftNode.right = new TreeNode(7);
        rightNode.right = new TreeNode(18);
        //TreeNode.preOrderTraverse(treeNode);//中序遍历
        int low = 7, high = 15;
        //System.out.println(new T0427().rangeSumBST(treeNode, low, high));
        System.out.println(new T0427().rangeSumBST1(treeNode, low, high));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        /*
         *前序遍历是针对二叉排序数 是有序的，左-根-右
         */
        List<Integer> res = new ArrayList<>();
        dfs(root, res);//实现前序遍历
        //直接计算list某个区间的总和
        return (int) res.stream().filter(item -> item >= low && item <= high)
                .mapToInt((s) -> s).summaryStatistics().getSum();
    }

    public void dfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }

    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) return 0;
        //root节点的值大于high：由于二叉搜索树右子树上的节点都大于根节点的值，
        // 即大于high；故无需考虑右子树，返回左子树范围之和
        if (root.val > high) {
            return rangeSumBST1(root.left, low, high);
        }
        //root节点的值小于low：由于二叉搜索树左子树上的节点都小于根节点的值，
        // 即小于low；故无需考虑左子树，返回右子树范围之和
        if (root.val < low) {
            return rangeSumBST1(root.right, low, high);
        }

        //root节点值处于[left:high]之内，返回root节点的值、左子树范围之和、右子树范围之和三个的值
        return root.val + rangeSumBST1(root.left, low, high)
                + rangeSumBST1(root.right, low, high);
    }
}
