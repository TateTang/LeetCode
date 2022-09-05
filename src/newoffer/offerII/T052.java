package newoffer.offerII;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmf
 * @date 2022年09月05日 09:25:​38
 * 剑指 Offer II 052. 展平二叉搜索树
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 */
public class T052 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(7);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        //leftNode.left = new TreeNode(4);
        //leftNode.right = new TreeNode(5);
        //rightNode.left = new TreeNode(6);
        TreeNode.inOrderTraverse(treeNode);
        System.out.println("--------");
        TreeNode.preOrderTraverse(new T052().increasingBST(treeNode));
    }

    public TreeNode increasingBST(TreeNode root) {
        /*
         * 题目要求我们返回按照中序遍历的结果改造而成的、只有右节点的等价二叉搜索树。我们可以进行如下操作：
         * 1.先对输入的二叉搜索树执行中序遍历，将结果保存到一个列表中；
         * 2.然后根据列表中的节点值，创建等价的只含有右节点的二叉搜索树，其过程等价于根据节点值创建一个链表。
         *
         */
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        // 使用虚拟节点
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for (Integer re : res) {
            currNode.right = new TreeNode(re);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    /**
     * 中序遍历，结果保存到一个list 中
     *
     * @param node node
     * @param res  res
     */
    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}
