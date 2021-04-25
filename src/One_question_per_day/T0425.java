package One_question_per_day;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2021/4/25 4:45 下午
 * @Description 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * 示例 1：
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 */
public class T0425 {
    private TreeNode resNode;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(7));
        TreeNode treeNode = new T0425().increasingBST(root);
        TreeNode.inOrderTraverse(treeNode);
        TreeNode.inOrderTraverse(new T0425().increasingBST1(treeNode));
    }

    public TreeNode increasingBST(TreeNode root) {
        /*
        中序遍历：左-根-右
        引入伪头节点：
		 - 由于初始状态树中无节点，因此循环第一轮时无法将节点添加到tree中中。 解决方案：初始化一个辅助节点 dummyNode
		 - 作为treeNode的伪头节点，将各节点添加至 dummyNode 之后。
		1、初始化： 伪头节点 dummyNode ，节点 currNode 指向 dummyNode
        2、先对输入的二叉搜索树执行中序遍历，将结果保存到一个列表中；
        3、然后根据列表中的节点值，创建等价的只含有右节点的二叉搜索树，其过程等价于根据节点值创建一个链表。
         */
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        TreeNode dummyNode = new TreeNode(-1);// 初始化一个值为 0 的节点，变量 node 引用指向它
        TreeNode currNode = dummyNode;// 节点 currNode 指向 dummyNode
        for (Integer re : res) {
            currNode.right = new TreeNode(re);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    public static void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    public TreeNode increasingBST1(TreeNode root) {
        /*
        中序遍历：左-根-右
        中序遍历的过程中改变节点指向
        1、方法一需要遍历一次二叉搜索树以后，然后再创建新的等价的二叉搜索树。
        2、事实上，还可以遍历一次输入二叉搜索树，在遍历的过程中改变节点指向以满足题目的要求。
        3、中序遍历的时候，修改节点指向就可以实现
        4、遍历到一个节点的时，把左孩子设置为空，并将其本身作为上一个遍历到的节点的右孩子
        5、这里需要有一些想象能力。递归遍历的过程中，由于递归函数的调用栈保存了节点的引用，因此上述操作可以实现
         */
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        dfs1(root);
        return dummyNode.right;
    }

    public void dfs1(TreeNode node) {
        if (node == null) return;
        dfs1(node.left);
        // 在中序遍历的过程中修改节点指向
        resNode.right = node;//本身作为上一个节点的右孩子
        node.left = null;//左孩子设置为空
        resNode = node;
        dfs1(node.right);
    }
}
